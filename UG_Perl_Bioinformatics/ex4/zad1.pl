#!/usr/bin/perl -w
#Napisać podprogram łączący dwa łańcuchy DNA.
use strict;
#use Bioinfo;
my $dnaA = "gcact";
my $dnaB = "gtgtatc";
my $joineddna = joined($dnaA,$dnaB);print "after joining $dnaA and $dnaB we get $joineddna";
###########
#podprogram
###########
sub joined {
	my ($dna1, $dna2) = @_;
	my $dna3 = $dna1.$dna2;
	return $dna3;
}
exit;
