#!/usr/bin/perl -w
#Napisać podprogram łączący dwa łańcuchy DNA.
use strict;
#use Bioinfo;
my $dnaA = "gcact";
my $dnaB = "gtgtatc";
my $joineddna = joined($dnaA,$dnaB);
###########
#podprogram
###########

	my ($dna1, $dna2) = @_;
	my $dna3 = $dna1.$dna2;
	return $dna3;
}
