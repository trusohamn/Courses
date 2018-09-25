#!/usr/bin/perl
#Napisać program, który poprosi o podanie jakiegoś nukleotydu, 
#a następnie w sposób losowy będzie próbował odgadnąć jaki to nukleotyd.
use Bioinfo;
use strict;
use warnings;
my $my_base;
my $comp_base;
my $count = 0;
srand(time|$$);

$my_base = give_me_base ("podaj nukleotyd: ");
do {
$comp_base = random_base();
print "$comp_base...";
++$count;
}until ($comp_base eq $my_base);
print "Matched after $count times!";
exit;
