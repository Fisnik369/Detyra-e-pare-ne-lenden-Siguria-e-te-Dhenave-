# Tap Code, Komanda Case dhe Komanda Ceasar


# Tap Code

Tap Code, nganjehere i quajtur edhe si Knock Code, eshte nje menyre e dekodimit te mesazheve, shkronje per shkronje, ne nje menyre te thjeshte.
Mesazhi transmetohet me ane te "tap sounds", prej nga e ka marre edhe emrin. Tap Code eshte perdorur nga te burgosurit ne Vietnam, per komunikim me njeri tjetrin. Tap Code eshte i bazuar ne Polybius Square, duke perdorur nje tabele 5x5, tabele e cila ka ne vete te gjitha shkronjat e alfabetit latin, pervec shkronjes K e cila perfaqesohet nga shkronja C.
 
 <img src="Images/TapCode.jpg" width="200">

# Ceasar Cipher

Ne kryptografi, Ceasar Cipher, eshte nje nga teknikat me te thjeshta dhe shume te njohura te enkriptimit. Eshte nje lloj i  substitution cipher, ku cdo shkronje zevendosohet me nje shkronje tjeter, duke u bazuar ne celesin qe i jepim. Psh: nese vendosim celesin 3 nga e majta, atehere shkronja D do te zevendesohej me shkronjen A.

 
 <img src="Images/Ceasar.png" width="300">
 
 # Komanda Case
 
 Komanda Case ka perfshire komandat uppercase(ku kthen shkronjat ne te gjitha te medha), lowercase(kthen shkronjat ne te gjitha te vogla), inverse(te kunderten per cdo shkronje) dhe capitalize(cdo shkronje te pare te cdo fjale e kthen ne shkronje te madhe).
 Me poshte jepen edhe shembujt e ekzekutimit te ketyre nenkomandave.
 #
 #
 *Ekzekutimi i programit behet ne command prompt, permes dhenies se argumenteve. Nese argumenti i pare eshte 't', atehere kemi te bejme me Tap Code, nese 'c' kemi te bejme me Ceasar Cipher dhe nese 'k' kemi te bejme me komanden Case.Ne raste tjera programi do te paraqes nje tekst qe dhenia e argumenteve eshte gabim. Ne rastin e Tap Code, argumenti i dyte dhe i trete jepen si fajlla dhe nese argumentet tjera jane 1 1, perdoruesi duhet te shenoj tekstin per t'a enkoduar, nese 1 2 vlen e kunderta. Ne rastin e Ceasar Cipher, argumenti i dyte 'e' nenkupton enkriptim, ndersa 'd' nenkupton dekriptim dhe 'b' per brute-force Ceasar Cipher. Pastaj japim tekstin dhe celesin perkates. Sa i perket komandes Case, argumenti i dyte percakton nenkomanden perkatese, ku:
 'U' - Uppercase,
 'L' - Lowercase,
 'I' - Inverse dhe
 'C' - Capitalize
 dhe pastaj shkruajme tekstin perkates.
 #
 #
 Kodi referues per komanden Tap Code eshte: https://github.com/ReinaldoDiasAbreu/tapcode, me disa modifikime!
 
 
 Kodi referues per komanden Ceasar Cipher eshte: https://github.com/VoxelPixel/CiphersInCplusplus
 
 Kodi referues per Brute-Force Ceasar Cipher: https://gist.github.com/rv5047/32054c80477440d3278aa3aeb44698d0, me disa modifikime!
 #
Shembuj te ekzekutimit te seciles komande dhe nenkomande:

   Enkriptimi:

<img src="Images/Enkriptimi.jpg" width="500">
   Dekriptimi:

<img src="Images/Dekriptimi.jpg" width="500">
   Uppercase:

<img src = "Images/Uppercase.jpg" width="500">
   Lowercase:

<img src = "Images/lowercase.jpg" width="500">
   Inverse:

<img src = "Images/Inverse.jpg" width="500">
   Capitalize:

<img src ="Images/Capitalize.jpg" width="500"> 
Enkodimi:

<img src = "Images/Enkodimi.jpg" width="500">
Dekodimi:

<img src = "Images/Dekodimi.jpg" width="500">

 Brute-Force:

<img src = "Images/Brute-Force.jpg" width="500">


# RSA Algoritmi(Algoritmet Asimetrike)



RSA Algoritmi eshte nje algoritem qe perdoret ne kompjuteret modern per te enkriptuar dhe dekriptuar mesazhe. Eshte nje algoritem kryptografik asimetrik. Asimetrik domethene qe ka dy celesa te ndryshem. Ky algoritem eshte i quajtur edhe si public key kryptografi, sepse nje celes mund te jepet tek secili. RSA eshte nje nga algoritmet me te njohura dhe me te perdorura per transmetimin e sigurt te te dhenave.

Ne vijim mund te shihen rezultatet e kompajllimit te kodit, te seciles komande vec e vec, sipas kerkesave te caktuara.


Rezulatatet e Kompajllimit:


<img src = "Images/CreateUser1.jpg" width="500">
<img src = "Images/CreateUser2.jpg" width="500">
<img src = "Images/ExportKey1.jpg" width="900">
<img src = "Images/ExportKey2.jpg" width="900">
<img src = "Images/ExportKey3.jpg" width="500">
<img src = "Images/deleteUser1.jpg" width="500">
<img src = "Images/deleteUser2.jpg" width="500">
<img src = "Images/importKey1.jpg" width="500">
<img src = "Images/importKey2.jpg" width="500">
<img src = "Images/writeMessage1.jpg" width="900">
<img src = "Images/writeMessage2.jpg" width="500">
<img src = "Images/readMessage.jpg" width="900">

# Faza e Trete e Projektit#


Ne komanden create-user, per te krijuar perdorues te ri duhet te krijojme edhe nje password. Emri i perdoruesit dhe passwordi ruhen ne nje fajll, ku passwordi ruhet si salted hash password. Argumenti i pare eshte "create-user" dhe me pas argumenti i dyte nenkupton emrin e perdoruesit qe do ta krijojme, me pastaj, na kerkohet te krijojme passwordin e perdoruesit. Passwordi duhet te permbaje me shume se 6 karaktere dhe po ashtu duhet te kete numra ose karaktere speciale. Me komanden "delete-user", pervec celesit privat dhe publik te user-it, fshihen edhe emri dhe passwordi i user-it ne bazen e shenimeve.

Rezultatet e kompajllimit:

<img src = "Images/create-user.jpg" width="900">
<img src = "Images/KaraktereSpeciale.jpg" width="900">
<img src = "Images/NukPerputhen.jpg" width="900">
<img src = "Images/NumraDheShkronja.jpg" width="900">
<img src = "Images/6karaktere.jpg" width="900">







