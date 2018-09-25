#!/usr/bin/perl
#Napisać program mutujący sekwencję białka.
use strict;
use warnings;
use Bioinfo;
# Deklarujemy zmienne
my $protein = "KPHNILIDHMGNIKVTDFGIATALSSTTITHTNSVLGSVHYLSP";
my $i;
my $mutant;
# Inicjujemy generator liczb losowych
srand(time|$$);
$mutant = mutateprotein($protein);
print "\nMutowanie bialka\n\n";
print "\nOryginalne bialko: \n\n";
print "$protein\n";
print "\nZmutowane bialko:\n\n";
print "$mutant\n";
# Powtarzamy mutowanie 10 razy
for ($i = 0; $i < 10; ++$i) {
$mutant = mutateprotein($mutant);
print "$mutant\n";
}
exit;
