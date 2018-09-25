#!/usr/bin/perl

#Napisać podprogram przestawiający w sposób losowy elementy tablicy.
#Podprogram powinien pobierać jako argument tablicę i zwracać tablicę 
#z poprzestawianymi elementami. 
#Każdy element może wystąpić tylko raz w wynikowej tablicy.
use strict;
use warnings;
use Bioinfo;
srand(time|$$);
my @newtablica=();
my @tablica = qw(Ala ma kota a pies to zwierz);
@newtablica = mixelementow(@tablica);

print "pierwotna tablica to: @tablica \n";
print "poprzestawiana tablica to: @newtablica\n";
exit;
