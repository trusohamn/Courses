#!/usr/bin/perl –w
#program program drukujący DNA małymi literami oraz program drukujący to 
#samo DNA wielkimi literami. Proszę zrobić to samo, co w zadaniu powyżej, z tym,
#że teraz proszę użyć dyrektyw łańcucha \U i \L
#odpowiednio dla liter wielkich i małych. Na przykład polecenie print „\U$DNA” 
#drukuje zawartość zmiennej $DNA wielkimi literami

$DNA = 'attcATCATCGcg';
print "DNA bez przerobki: ". $DNA;


print "\nDNA big letters: " ."\U$DNA";


print "\nDNA small letters: " ."\L$DNA";


exit;