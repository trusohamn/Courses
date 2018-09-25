#!/usr/bin/perl –w
#Proszę napisać program obczytujący zwartość pliku i drukujący linie w odwrotnej
#kolejności. Można spróbować skorzystać z funkcji push, pop, shift i unshift. Innym wyjściem jest
#odwrócenie tablicy zawierającej linie odczytane z pliku

$k1 = 'bialko.pep';
open(PROTEINFILE,$k1);
#zachowanie calej wartosci w tablicy
@k1 = <PROTEINFILE>;
print @k1;
print "\n\n";
close PROTEINFILE;
#odwrócenie tablicy
@reverse = reverse@k1;
print @reverse;

exit;
