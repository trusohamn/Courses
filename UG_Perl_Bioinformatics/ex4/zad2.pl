#!/usr/bin/perl -w
#Napisać podprogram informujący o procencie występowania każdego
# z nukleotydów w DNA. Może się przydać
#funkcja int, która pozwala na odrzucenie części ułamkowej liczby.
use strict;
#use Bioinfo;

my $dnaA = "atatatatagggcc";
my $procent = nucleotides ($dnaA);

###########
#podprogram
###########
sub nucleotides {
	my ($dna) = @_;
	print "DNA sekw: $dna ";
	my $total = length $dna;
	my $nucA = ($dna =~ tr/Aa//);
	my $nucT = ($dna =~ tr/Tt//);
	my $nucC = ($dna =~ tr/Gg//);
	my $nucG = ($dna =~ tr/Cc//);
	my $procentA = int(( $nucA / $total)*100);
	my $procentT = int(( $nucT / $total)*100);
	my $procentC = int(( $nucC / $total)*100);
	my $procentG = int(( $nucG / $total)*100);
	print "\n\nW sekwencji dna wystepuje  $procentA% A, $procentT% T, $procentC% C, $procentG% G";
	
}
exit;
