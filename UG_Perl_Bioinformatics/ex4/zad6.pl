#!/usr/bin/perl -w
#Napisać moduł, który będzie podawał różne informacje na temat 
#sekwencji DNA, na przykład takie jak długość
#łańcucha, zawartość GC, obecność lub nieobecność poli-T lub inne.
use strict;
print "DNA: $dna";
require Informations;
Informations::poliT($dna);
