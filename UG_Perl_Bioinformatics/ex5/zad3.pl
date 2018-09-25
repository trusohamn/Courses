#Napisać podprogram szukający określonej nazwy genu 
#w tablicy asocjacyjnej. Klucze w tablicy będą nazwami
#genów, a wartości na przykład sekwencjami.

#!/usr/bin/perl
use strict;
use warnings;
use Bioinfo;
print "im looking for: ";
my $name = <>;
chomp $name;
my %genefunction = (
'ABO' 	=>	'Glycosyltransferases',
'ALB' 	=>	'Serum albumin',
'BCL2' 	=>	'Apoptosis regulator Bcl-2', 
'CCR5' 	=>	'chemokine (C-C motif) receptor 5', 	
'CD4' 	=>	'CD4 antigen', 	
'CD8' 	=>	'CD8 antigen', 	
'IL2' 	=>	'Interleukin 2', 	
'IL10' 	=>	'Interleukin 10', 	);
search_gene_name_in_hash($name,  %genefunction);
exit;