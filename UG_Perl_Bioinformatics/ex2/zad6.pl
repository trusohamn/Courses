#!/usr/bin/perl –w
#Napisać program, który sprawdza, 
#czy dwie sekwencje podane jako argumenty są do siebie komplementarne

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

#tworze dna komplementarne do dna2
$dna2kompl = reverse $dna2;
$dna2kompl =~ tr/AaGgCcTt/TTCCGGAA/;
#print "$dna2kompl \n";
#porownuje dna komplementarne do dna2 i dna1
if ($dna1 eq $dna2kompl){print "dna jest komplementarne w 100%";}
else {print "dna nie jest w 100% komplementarne \n";
$komplem = 0;
$total = length $dna1;
for($position=0; $position< length $dna1; ++$position) {	
	$basea = substr ($dna1,$position,1);
	$baseb = substr ($dna2kompl,$position,1);
	if ($basea eq $baseb) {print "X"; ++$komplem;}
	else {print ".";}
}

$procent = ( $komplem / $total)*100;
printf "\n\nDna jest komplementarne w %.1f", $procent;
print "%";
};

exit;