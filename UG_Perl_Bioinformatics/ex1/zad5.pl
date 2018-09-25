#!/usr/bin/perl –w
#Proszę odczytać dwa pliki i wydrukować ich zawartość jedna po drugiej

$k1 = 'bialko.pep';
open(PROTEINFILE,$k1);
#zachowanie calej wartosci w tablicy
@k1 = <PROTEINFILE>;
print @k1;
close PROTEINFILE;


$k2 = 'bialko2.pep';
open(PROTEINFILE2,$k2);
@k2 = <PROTEINFILE2>;
print "\n\n";
print @k2;
close PROTEINFILE2;

exit;
