#!/usr/bin/perl
use strict;
use warnings;
use Bioinfo;
#Napisać podprogram, 
#który poszukiwałby określonej nazwy genu w tablicy.

print"im looking for: ";
my $gene = <>;
chomp $gene;
my @tablica = qw(APP GAST INS LCK LEP LIF);

search_gene_name($gene,@tablica);

exit;