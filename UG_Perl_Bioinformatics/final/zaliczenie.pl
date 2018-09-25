#!/usr/bin/perl
#program poszukujący w sekwencji DNA miejsc metylacji metylazy Dam (GATC)
#pseudokod: 
#	1 odszukanie i pobranie sekwencji metylowanej przez Dam w hashliście
#	2 wczytanie sekwencji DNA
#	3 wyszukanie sekwencji metylowanej w sekwencji DNA
#	4 zwrócenie ilości wyników
#	5 zwrócenie wyniku w postaci graficznej w wyznaczonej skali

use strict;
use warnings;
my $seq;
my $dna;
#	1 odszukanie i pobranie sekwencji metylowanej przez Dam w hashliście
$seq = metylazy('Dam');
print "metylowana sekwencja to $seq\n";
#	2 wczytanie sekwencji DNA
$dna = pobierzseq('dnaA.txt');
print $dna;
#	3 wyszukanie sekwencji metylowanej w sekwencji DNA
	my $count = 0;
	while ($dna =~ /$seq/ig) {
		++$count;	
	}
#	4 zwrócenie ilości wyników
	print "\nilosc znalezionyc miejsc metylacji to $count\n";
#	5 zwrócenie wyniku w postaci graficznej
rysunek (3,$dna);
############
#Subroutines
############
sub rysunek {
my ($skala,$dna) = @_;
my $caly = (length $dna) / $skala;
my @positions=();
my @rysunek;	
	while ($dna =~ /$seq/ig) {
		push(@positions, pos($dna));	
	}
	for (my $licznik = 0;$licznik<$caly; ++$licznik){
	$rysunek[$licznik] = "-";}
	foreach my $pozycja(@positions){
	$pozycja = int($pozycja/$skala);
	$rysunek[$pozycja] = "*";
}
print @rysunek;	}
sub metylazy {
my($metylaza) = @_;
  my(%metylazy) = (
  'Dam' => 'GATC',
  );
  
  if(exists $metylazy{$metylaza}) {
    return $metylazy{$metylaza};
  } else {
    print STDERR "Nie ma takiej metylazy \n";
    exit;
  }
}
sub pobierzseq {
my ($seq) = @_;
unless (-e $seq) {
	print "plik nie istnieje";
	exit;
};
unless (open(AMINFILE, $seq)) {
	print"nie mozna otworzyc pliku";
	exit;
};
my @dna = <AMINFILE>;
close AMINFILE;
my $dna = join ('',@dna);
$dna =~s/\s//g;
return $dna;}