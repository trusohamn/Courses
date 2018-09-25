#!/usr/bin/perl –w
#Napisać program, który poda procent par GC w danej sekwencji.

#getting dna
print "plik z sekw dna: ";
$amin = <>;
chomp $amin;
unless (-e $amin) {
	print "\nplik nie istnieje";
	exit;
};
unless (open(AMINFILE, $amin)) {
	print"\nnie mozna otworzyc pliku";
	exit;
};
@amin = <AMINFILE>;
close AMINFILE;
$dna1 = join ('',@amin);
$dna1 =~s/\s//g;
print "DNA1 sekw: ";
print $dna1;
$total = length $dna1;
$parygc = ($dna1 =~ tr/GgCc//);

$procent = ( $parygc / $total)*100;
printf "\n\nW sekwencji dna wystepuje %.1f", $procent;
print "% par GC";


exit;