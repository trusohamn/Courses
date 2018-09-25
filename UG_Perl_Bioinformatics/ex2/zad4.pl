#!/usr/bin/perl –w
#Napisać program, który wydrukuje sekwencję łańcucha komplementarnego 
#(w orientacji 5’-3’). Proszę nie korzystać z funkcji s/// lub tr///. 
#Należy użyć funkcji substr i zmieniać zasady pojedynczo.

print "plik z sekw DNA:  ";
$dna = <>;
chomp $dna;

unless (-e $dna) {
	print "plik nie istnieje";
	exit;
};
unless (open(DNAFILE, $dna)) {
	print"nie mozna otworzyc pliku";
	exit;
};
@DNA = <DNAFILE>;
close DNAFILE;

$dna = join ('',@DNA);
$dna =~s/\s//g;
print "DNA sekw: \n";
print $dna;
print "\n";
print "DNA komplementarne sekw: \n";

for($position = length $dna ; $position>=0; --$position) {	
	$base = substr ($dna,$position,1);
	if ($base eq 'G' or $base eq 'g'){print "C"};
	if ($base eq 'C' or $base eq 'c'){print "G"};
	if ($base eq 'A' or $base eq 'a'){print "T"};
	if ($base eq 'T' or $base eq 't'){print "A"};
};
exit;