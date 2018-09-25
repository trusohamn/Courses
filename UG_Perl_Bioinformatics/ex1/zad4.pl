#!/usr/bin/perl –w
#program do odwrotnej transkrypcji

$RNA = 'aUUcAuCAuCGcg';
print "oto wyjsciowe RNA: ". "\U$RNA";

#odwrotna transkrypcja
$DNA = $RNA;
$DNA =~ s/U/T/gi;

print "\n\noto DNA po odwrotnej transkrypcji: " . "\U$DNA";


exit;