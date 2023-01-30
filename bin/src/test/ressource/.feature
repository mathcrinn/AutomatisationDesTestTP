
Feature : to know the quality management rule of an article


Scenario : object is a normal object 
Given: a normal object exists in the stock 
When: we want to know the rule of management its quality
Then: the response returned is "once the item's expiration
 date has passed, its quality degrades days after days".


Scenario: L'objet est un objet simple
Given qu'un objet passe de concert à été ajouté 
When l'administrateur veut connaitre sa qualité
Then la qualité retournée est " qualité se dégrader de deux fois plus vite que les objets normaux."


Scenario: L'objet est un fromage
Given qu'un objet fromage à été ajouté 
When l'administrateur veut connaitre sa qualité
Alors la qualité retournée est "sa qualité augmente plus le temps passe"


Scenario: L'objet est un objet Legendaire
Given qu'un objet légendraire à été ajouté 
When l'administrateur veut connaitre sa qualité
Then la règle retournée est "l'article ne perd jamais en qualité"


Scenario: L'objet est un objet conjuré
Given qu'un objet conjuré à été ajouté 
When l'administrateur veut connaitre sa qualité
Then la règle retournée est  "sa qualité se dégrade de deux fois plus vite que les objets normaux"



