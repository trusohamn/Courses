#!/usr/bin/perl -w
#Napisać podprogram, który będzie powtarzał prośbę o podanie 
#nazwy pliku dopóki nie zostanie podana nazwa
#istniejącego pliku lub dopóki użytkownik nie zrobi tego pięć razy.
use strict;
#use Bioinfo;

my $question = file();
###########
#podprogram
###########
sub file{
	for(my $i=0;$i<5;$i++) {		print "podaj nazwe pliku: ";
		my $question = <>;
		chomp $question;
		if (-e $question) {
			return $question;
			}	
}}
exit;
