#!/usr/bin/perl -w
#Napisać podprogram, który będzie sprawdzał, 
#czy podczas uruchamiania programu w linii poleceń pojawił się
#argument taki jak –help, -h lub --h. W przypadku, gdy wystąpi 
#któryś z wymienionych argumentów
#podprogram powinien zwracać prawdę, a następnie program powinien 
#drukować instrukcję dla użytkownika
#zdefiniowaną w zmiennej $USAGE i zakończyć działanie.
use strict;
#use Bioinfo;
my $USAGE = "$0 tu znajdziesz pomoc";
my $question = $ARGV[0];
my $answer = pomoc($question);
if ($answer) {
	print $USAGE;} 
###########
#podprogram
###########
sub pomoc{
	my ($question)= @_;
	if (@ARGV) {
	if ($question eq "-help" or $question eq "-h" or $question eq "--h")
	{return 1;}
	}
	
}
exit;
