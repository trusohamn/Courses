#!/usr/bin/perl -w
#Napisać moduł, który będzie podawał różne informacje na temat 
#sekwencji DNA, na przykład takie jak długość
#łańcucha, zawartość GC, obecność lub nieobecność poli-T lub inne.
use strict;my $dna = "cacacacacattatttttaggggg\n";
print "DNA: $dna";
require Informations;Informations::seq($dna);Informations::pairs($dna);
Informations::poliT($dna);
exit;
