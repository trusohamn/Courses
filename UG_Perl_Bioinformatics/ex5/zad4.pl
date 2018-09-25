
#Napisać podprogram sprawdzający czy dana sekwencja jest w formacie FASTA.
#!/usr/bin/perl

use strict;
use warnings;
use Bioinfo;
my $file = "fastaex.txt";
my @file=get_file_data($file);
try_fasta(@file);

exit;