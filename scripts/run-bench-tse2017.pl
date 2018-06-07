#!/usr/bin/perl

use strict;

if (@ARGV != 3) {
    die "Usage: run-bench-tse2017.pl <benchmark> <mode> <size>\n";
}
my($benchmark, $mode, $size) = @ARGV;

my %known_benchmarks =
  ("NanoXML" => ["DumpXML", "mainProcess"],
   "ApacheCLI" => ["CLI", "mainProcess"],
   "siena" => ["SENPDriver", "mainProcess"],
  );

if (not exists $known_benchmarks{$benchmark}) {
    die "Unrecognized benchmark '$benchmark'\n";
}

my($driver_class, $driver_method) = @{$known_benchmarks{$benchmark}};

if ($mode ne "vanilla" and $mode ne "ranger") {
    die "Unrecognized mode '$mode': should be 'vanilla' or 'ranger'\n";
}

if ($size ne int($size) or $size < 1 or $size > 9) {
    die "Size should be between 1 and 9\n";
}

my $sp_file = "$ENV{HOME}/.jpf/site.properties";

if (not -e $sp_file) {
    die "Unable to find properties file $sp_file\n";
}

my $jpf_core_loc;
my $jpf_symbc_loc;
my $ranger_bmarks_loc;

open(SP, "<", $sp_file)
  or die "Failed to open $sp_file for reading: $!";
while (<SP>) {
    next unless /^\s*([\w-]+)\s*=\s*(.*)\s*$/;
    my($var, $val) = ($1, $2);
    if ($var eq "jpf-core") {
	$jpf_core_loc = $val;
    } elsif ($var eq "jpf-symbc") {
	$jpf_symbc_loc = $val;
    } elsif ($var eq "ranger-bmarks") {
	$ranger_bmarks_loc = $val;
    } else {
	next;
    }
    if ($val =~ /\$/) {
	die "site.properties values containing other variables not supported";
    }
}
close SP;

if (not defined $jpf_core_loc) {
    die "$sp_file missing definition of jpf-core\n";
} elsif (not -e "$jpf_core_loc/jpf.properties") {
    die "$jpf_core_loc does not appear to contain the JPF core";
}

if (not defined $jpf_symbc_loc) {
    die "$sp_file missing definition of jpf-symbc\n";
} elsif (not -e "$jpf_symbc_loc/ReadmeMultipleDecisionProcedures") {
    die "$jpf_symbc_loc does not appear to contain SPF";
}

if (not defined $ranger_bmarks_loc) {
    die "$sp_file missing definition of ranger-bmarks\n";
} elsif (not -e "$ranger_bmarks_loc/scripts/run-bench-tse2017.pl") {
    die "$ranger_bmarks_loc does not appear to contain " .
      "the Java Ranger benchmarks";
}

my $extra_lib = "$jpf_symbc_loc/lib";
if (length $ENV{"LD_LIBRARY_PATH"}) {
    $ENV{"LD_LIBRARY_PATH"} = "$extra_lib:$ENV{LD_LIBRARY_PATH}"
} else {
    $ENV{"LD_LIBRARY_PATH"} = $extra_lib;
}
print "env LD_LIBRARY_PATH=$ENV{LD_LIBRARY_PATH}\n";

my $class_dir = "$ranger_bmarks_loc/TSE-2017/$benchmark";
$ENV{"TARGET_CLASSPATH_WALA"} = $class_dir;
print "env TARGET_CLASSPATH_WALA=$ENV{TARGET_CLASSPATH_WALA}\n";

my @java_opts =
  ("-Xmx1024m", # Use 1GB heap
   "-ea", # enable assertions
  );

push @java_opts, "-Djava.library.path=$extra_lib";

my $runjpf = "$jpf_core_loc/build/RunJPF.jar";
-e $runjpf or die "Missing $runjpf\n";
push @java_opts, ("-jar", $runjpf);

my $ctrl_file = "$class_dir/$benchmark-$mode-$size.jpf";

open(CTRL, ">", $ctrl_file)
  or die "Can't open $ctrl_file for writing: $!";
print CTRL "target=$driver_class\n";
print CTRL "classpath=\${ranger-bmarks}/TSE-2017/$benchmark\n";
print CTRL "sourcepath=\${ranger-bmarks}/TSE-2017/$benchmark\n";
my @method_args = (("sym") x $size, ("conc") x (9 - $size));
my $method_args = join "#", @method_args;
print CTRL "symbolic.method = $driver_class.$driver_method($method_args)\n";
print CTRL "vm.storage.class=nil\n";
if ($mode eq "vanilla") {
    print CTRL "listener = .symbc.SymbolicListener\n";
} elsif ($mode eq "ranger") {
    print CTRL "listener = .symbc.VeritestingListener\n";
    print CTRL "veritestingMode = 3\n";
} else {
    die;
}
print CTRL "symbolic.dp=z3bitvector\n";
close CTRL;

-e $ctrl_file or die "Missing control file $ctrl_file\n";
push @java_opts, $ctrl_file;

my $java_prog = `which java`;
die $java_prog if $java_prog =~ /not found/;
chomp $java_prog;
die "Could not find java" unless length $java_prog;
-x $java_prog or die "$java_prog does not appear to be executable";

my @cmd = ($java_prog, @java_opts);
print join(" ", @cmd), "\n";

# We have to be in a directory where
# ../MyJava60RegressionExclusions.txt is available
chdir("$jpf_symbc_loc/src");

system(@cmd);
