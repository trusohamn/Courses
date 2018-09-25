#!/usr/bin/perl –w
#Napisać program, który zamienia dwie zasady w określonej pozycji 
#w sekwencji DNA. Można spróbować wykorzystać funkcję substr lub splice.

#getting dna
print "plik z sekw dna: ";
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
$dna = join ('',@amin);
$dna =~s/\s//g;
print "DNA sekw: \n";
print $dna;
print "\nIle podmian chcesz dokonac? ";
$podmiany = <>;

for($i=0;$i<$podmiany;++$i)
{
print"\nprosze podac pozycje podmiany pierwszej 
z zasad oraz ilosc zasad do podmiany: ";
$pozycja = <>;
$ilosc = <>;
$zasada = substr ($dna, $pozycja-1,$ilosc);
print "zasady, ktore chcesz podmienic to: $zasada\n";
print "na jakie zasady chcesz ja podmienic? ";
$nowazasada = <>;
chomp $nowazasada;
substr($dna, $pozycja-1, $ilosc) = $nowazasada;
print "oto nowe dna:\n $dna \n";
};


exit;