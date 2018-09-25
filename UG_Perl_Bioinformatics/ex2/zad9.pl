#!/usr/bin/perl –w
#Napisać program, który zapisuje czasowy plik, a następnie usuwa go.
#Funkcja unlink usuwa plik, na przykład:
#unlink „tmpfile”
#Program powinien sprawdzić, czy usunięcie pliku powiodło się..

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
print "\n Ile podmian chcesz dokonac? ";
$podmiany = <>;

for($i=0;$i<$podmiany;++$i)
{
print"\nprosze podac pozycje podmiany pierwszej 
z dwoch zasad oraz ilosc zasad do podmiany: ";
$pozycja = <>;
$ilosc = <>;
$zasada = substr ($dna, $pozycja-1,$ilosc);
print "zasady, ktore chcesz podmienic to: $zasada\n";
print "na jakie zasady chcesz ja podmienic? ";
$nowazasada = <>;
chomp $nowazasada;
substr($dna, $pozycja-1, $ilosc) = $nowazasada;
print "oto nowe dna:\n$dna \n";
}


$file = "tmpdna.txt";
unless(open (COUNTBASE, ">$file")) {
	print " \n nie moge otworzyc pliku";
	exit;}
print COUNTBASE "nowe dna : $dna";
close COUNTBASE;
print "chcesz usunac plik tymczasowy? (y/n)  ";
$answer = <>;
chomp $answer;
if ($answer eq 'y') {
	unlink "tmpdna.txt";
	print "plik usunieto";
	
	unless (-e "tmpdna.txt") {
	print "\n plik nie istnieje";
	}}
else {
		print "plik nie zostal usuniety";}


exit;