#!/usr/bin/perl –w
#program program drukujący DNA małymi literami oraz program drukujący to 
#samo DNA wielkimi literami. Proszę skorzystać z funkcji tr///.

$DNA = 'attcATCATCGcg';
print "DNA bez przerobki: ". $DNA;

$bigDNA = $DNA;
$bigDNA =~ tr/atcg/ATCG/;
print "\nDNA big letters: " .$bigDNA;

$smallDNA=$bigDNA;
$smallDNA =~ tr/TACG/tacg/;
print "\nDNA small letters: " .$smallDNA;


exit;