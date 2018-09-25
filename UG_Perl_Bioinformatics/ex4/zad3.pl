#!/usr/bin/perl -w
#Napisać podprogram, który będzie drukował pytanie do użytkownika 
#oraz pobierał od niego odpowiedź.
#Argumentem przekazywanym podprogramowi powinno być owo pytanie, 
#a zwracana przez podprogram ma być odpowiedź użytkownika.
use strict;
use Bioinfo;

my $question = "Lubisz science?   ";
my $answer = questions($question);

###########
#podprogram
###########
sub questions {
	my ($question) = @_;
	print $question;
	my $answer = <>;
	return $answer;
}exit;
