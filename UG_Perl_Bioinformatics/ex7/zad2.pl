#!/usr/bin/perl
#Napisać program, który wybiera losowo jeden nukleotyd 
#oraz prosi użytkownika o zgadnięcie jaki to nukleotyd.

use strict;
use warnings;
use Bioinfo;
my $my_base;
my $comp_base;
my $count = 0;
srand(time|$$);

$comp_base = random_base();
do {
$my_base = give_me_base("podaj nukleotyd: ");
++$count;
}until ($comp_base eq $my_base);
print "Matched after $count times!";

exit;
