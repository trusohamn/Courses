#!/usr/bin/perl –w
#SEKWENCJA CONSENSUS
#troche zmodyfikowalam zadanie 6 z poprzednich zadań

#getting dna1"
print "plik z sekw dna1: ";
$amin = <>;
chomp $amin;
unless (-e $amin) {
	print "plik nie istnieje";
	exit;
};
unless (open(AMINFILE, $amin)) {
	print"nie mozna otworzyc pliku";
	exit;
};
@amin = <AMINFILE>;
close AMINFILE;
$dna1 = join ('',@amin);
$dna1 =~s/\s//g;
print "DNA1 sekw: ";
print $dna1;

#getting dna2
print "\n plik z sekw dna2: ";
$amin = <>;
chomp $amin;
unless (-e $amin) {
	print "plik nie istnieje";
	exit;
};
unless (open(AMINFILE, $amin)) {
	print"nie mozna otworzyc pliku";
	exit;
};
@amin = <AMINFILE>;
close AMINFILE;
$dna2 = join ('',@amin);
$dna2 =~s/\s//g;
print "DNA2 sekw: ";
print "$dna2 \n";


#porownuje dna1 do dna2

for($position=0; $position< length $dna1; ++$position) {	
	$basea = substr ($dna1,$position,1);
	$baseb = substr ($dna2,$position,1);
	if ($basea eq $baseb) {print "$basea"}
	else {print "-";}
}


exit;