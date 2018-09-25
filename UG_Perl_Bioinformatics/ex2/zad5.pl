#!/usr/bin/perl –w
#Napisać program do obliczenia procentu hydrofobowych
#aminokwasów w sekwencji białkowej.
print "plik z sekw amin:  ";
$amin = <>;
chomp $amin;
unless (-e $amin) {
	print "\n plik nie istnieje";
	exit;
};
unless (open(AMINFILE, $amin)) {
	print"\n nie mozna otworzyc pliku";
	exit;
};
@amin = <AMINFILE>;
close AMINFILE;
#print @amin;
$amin = join ('',@amin);
$amin =~s/\s//g;
print "AMIN sekw: ";
print $amin;
print "\n liczba aminokwasow: ";
$total = length $amin;
print $total;
print "\n liczba aminokwasow hydrofobowych: ";
#liczy ilosc "usunięć"
$hydr = ($amin =~ tr/AaCcGgTtVvIiLlMmFfYyWwHhKk//);	
print $hydr;
print "\n procent hydrofobowych: ";
$procent = ( $hydr / $total)*100;
#redukuje ilosc miejsc po przecinku
printf "%.1f", $procent;
print "%";
exit;