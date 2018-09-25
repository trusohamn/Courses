#Napisać podprogram sprawdzający, czy podany łańcuch 
#jest sekwencją DNA. Drugi podprogram powinien
#sprawdzać, czy to sekwencja białka.
#!/usr/bin/perl
use strict;
use warnings;
use Bioinfo;
my $file_data = '';
$file_data = pobierzseq("dnaA.txt");
check_dna($file_data);
my $file_data2 = '';
$file_data2 = pobierzseq("bialko.pep");
check_protein($file_data2);
exit;