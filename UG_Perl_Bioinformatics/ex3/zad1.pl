#!/usr/bin/perl –w
#POSZUKIWANIE MOTYWÓW W SEKWENCJI
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
#searching for motywy dna w dna sequence
@wyniki = ();
foreach $motif(@motywy){	
	$count = 0;
	$motif =~ s/\s//g;
	while ($dna =~ /$motif/ig) {
		++$count;	
	}
	push @wyniki, ($motif, $count);
} 
%wyniki = @wyniki;
#printing
foreach $wynik(keys %wyniki){
	print " \n ";
	print $wynik;
	print ":  $wyniki{$wynik}";
}
print " \n\nafter sorting \n";
#sorting and printing
foreach $name (sort { $wyniki{$b} <=> $wyniki{$a} } keys %wyniki) {
printf "%-8s %s\n", $name, $wyniki{$name};
    }

exit;
