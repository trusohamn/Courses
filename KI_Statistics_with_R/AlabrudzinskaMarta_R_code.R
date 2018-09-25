
#data load
setwd("C:/Users/mlecz_000/Desktop/Statistics with R/mydata")
data<- read.csv("AlabrudzinskaMarta_R_data.csv")

#data overview
dim(data)
head(data)
tail(data)
names(data)
str(data)
table(data$Mouse)
table(data$Genotype)

#data rearengment 
library(reshape2)
datawide <- reshape(data, idvar=c("Genotype", "Mouse", "Islet"  ), direction="wide", timevar="Week")

#add difference between Week 4 and 1
datawide$diffLengthVolume <- datawide$Length.Volume.W4/datawide$Length.Volume.W1
datawide$diffLength <- datawide$Dendrite_Length.W4/datawide$Dendrite_Length.W1

#data cleaning
datawide$diffLength[datawide$diffLength>8]=NA
datawide$diffLengthVolume[datawide$diffLengthVolume>5]=NA

#Table 1: Baseline characteristics
library(tableone)
library(knitr)
tab1 <- CreateTableOne(vars = c("diffLength", "diffLengthVolume"), strata ="Genotype",data = datawide, test=F, includeNA=TRUE)
kable(print(tab1), align = "r")

#boxplot
par(mfrow=c(1,2))
par(oma=c(0,0,0,0))
par(mar=c(2,3,4,0.5))

boxplot(datawide$diffLength ~ datawide$Genotype, at=c(2,3,4,1), cex.axis=0.9, col=c(1:4), 
        main="Difference in length of vasculature \n between after 4 weeks", ylab="ratio")


boxplot(datawide$diffLengthVolume ~ datawide$Genotype, at=c(2,3,4,1), cex.axis=0.9, col=c(1:4),
        main="Difference in length\n of vasculature/volume \nbetween after 4 weeks")

#linear timelapse plot
total <-length(datawide$Genotype)
gen <- c("wt", "RipVEGFB", "RT2", "RT2.RipVEGFB")
par(mfrow=c(2,2))
par(oma=c(0,0,2,0))
par(mar=c(2,3,1.5,0.5))
maxvalue <- ceiling(max(data$Dendrite_Length))

for(g in gen){
  n=length(datawide$Genotype[datawide$Genotype==g])
  colors<-palette(rainbow(n))
  c=1
  par(new=F)
    for (a in (1:total)){
      if (datawide$Genotype[a]==g){
        vector<-c(datawide$Dendrite_Length.W1[a], datawide$Dendrite_Length.W2[a], datawide$Dendrite_Length.W3[a], datawide$Dendrite_Length.W4[a])
        if(sum(is.na(vector))==0){
          plot(vector, col=colors[c], type="l", ylim=c(0,maxvalue), axes=F, xlab="", ylab="", main=g)
          par(new=T)
          c=c+1
      }
    }
  }
  axis(1, at=c(1, 2, 3, 4), labels=c("week1", "week2", "week3", "week4"), cex.axis=0.8)
  axis(2, las=2, cex.axis=0.8)
 }

mtext("Change in length of the islet vasculature", outer = T, side = 3, cex =1.5, font =2)



#STATISTICS
tt1<-t.test(datawide$diffLength[datawide$Genotype=="wt"],datawide$diffLength[datawide$Genotype=="RT2"],var.equal = TRUE)
tt2<-t.test(datawide$diffLength[datawide$Genotype=="wt"],datawide$diffLength[datawide$Genotype=="RipVEGFB"],var.equal = TRUE)
tt3<-t.test(datawide$diffLength[datawide$Genotype=="RT2"],datawide$diffLength[datawide$Genotype=="RT2.RipVEGFB"],var.equal = TRUE)


r1 <- rbind(c(tt1[1:3])); r1 <- cbind(test="wt - RT2", r1)
r2 <-rbind(c(tt2[1:3])); r2 <- cbind(test="wt - RipVEGFB", r2)
r3 <-rbind(c(tt3[1:3])); r3 <- cbind(test="RT2 - RT2.RipVEGFB", r3)

kable(rbind(r1,r2,r3), digits=3, col.names = c("test", "t-value", "df", "p-value"))

