#!/usr/bin/perl –w
#Poprosić użytkownika o wprowadzenie dwóch krótkich łańcuchów DNA. 
#Połączyć je ze sobą używając operatora „.=”. Wydrukować połączone łańcuchy, a następnie 
#wydrukować drugi łańcuch tak, aby otrzymać przedstawioną poniżej sytuację.
#Łańcuchy: AAAA oraz TTTT
#AAAATTTT
#TTTT
print "podaj lancuch dna: ";
$dna1 = <>;
print "podaj 2 lancuch dna: ";
$dna2 = <>;
#usuwanie przejscia do nowej lini!!
chomp $dna1;
$dna1 .= $dna2;

print $dna1;
print "\n";
print $dna2;
exit;
