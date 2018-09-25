#!/usr/bin/perl –w
#NAJPROSTSZA GRAFIKA
#getting dna sequence, saving in scalar"
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
$dna = join ('',@amin);
$dna =~s/\s//g;
print "DNA1 sekw: ";
print $dna;

#saving a scale
$skala = 3;
#getting motywy dna, saving in array
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
@motywy = <AMINFILE>;
close AMINFILE;
chomp @motywy;
print "motywy: ";
print "@motywy \n";
#scaling
$caly = (length $dna) / $skala;
#searching for motywy dna w dna sequence, saving the position
@wyniki = ();
foreach $motif(@motywy){
	@positions=();	
	while ($dna =~ /$motif/ig) {
		push(@positions, pos($dna));	
	}
print "\n";

#tablica rysunku 
for ($licznik = 0;$licznik<$caly; ++$licznik){
	$rysunek[$licznik] = "-";}
#wstawienie gwiazdek w miejsce trafienia
foreach $pozycja(@positions){
	#print " $pozycja";
	$pozycja = int($pozycja/$skala);
	#print "  $pozycja";}
	$rysunek[$pozycja] = "*";
	
}
print "\n";
print$motif;
print "\n";
print @rysunek;	}

exit;
