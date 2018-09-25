#!/usr/bin/perl
#Napisać podprogram, który będzie pobierać kodon 
#a zwracać jego losową mutację.
use strict;
use warnings;
use Bioinfo;
srand(time|$$);
my $codon;
my $newcodon;
my $aminoacid;
my $newaminoacid;
#pobieram kodon
$codon = give_me_codon("podaj kodon: ");
#mutacja
$newcodon = mutate ($codon);
#translacja
$aminoacid = codon2aa ($codon);
$newaminoacid = codon2aa ($newcodon);

print "Po zmutowaniu kodonu $codon otrzymano kodon $newcodon,";
print "co zaskutkowalo zmiana aminokwasu $aminoacid na $newaminoacid";
exit;
