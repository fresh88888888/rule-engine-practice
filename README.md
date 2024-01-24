# rule-engine-practice
Predictive models can be used to improve decision making throughout an organization’s daily operations and throughout their customer’s journey. Examples of predictive modeling applications include (but are not limited to):

```plantuml
@startuml
'!includeurl https://raw.githubusercontent.com/ebbypeter/Archimate-PlantUML/master/Archimate.puml

'element
skinparam roundcorner 20
rectangle "KieServices" as KS #Business
rectangle "KieContainerImpl.getKieBase(var kBaseName)" as KB #Business
rectangle "KieContainerImpl.createKieBase(...)" as KCI #Business
rectangle "AbstractKieModule.createKieBase(...)" as AKM #Business
rectangle "AbstractKieModule.buildKnowledgePackages(...)" as AKM2 #Business

rectangle "AbstractKieProject.buildKnowledgePackages(...)" as AKP #Business
rectangle "CompositeKnowledgeBuilderImpl.build(...)" as CKBI #Business
rectangle "CompositeKnowledgeBuilderImpl.buildPackageDescr(...)" as CKBI2 #Business
rectangle "PackageDescrBuilder.build(...)" as PDB #Business
rectangle "PackageDescrBuilder.buildResource(...)" as PDB2 #Business
rectangle "PackageDescrBuilder.registerPackageDescr(...)" as PDB3 #Business
rectangle "CompositePackageDescr.addPackageDescr(...)" as CPD #Business
rectangle "CompositePackageDescr.internalAdd(...)" as CPD2 #Business

rectangle "AbstractKieModule.addPackages(...)" as AKM3 #Business
rectangle "KnowledgeBaseImpl.addPackages(...)" as KBI #Business
rectangle "KnowledgeBaseImpl.kBaseInternal_addPackages(...)" as KBI2 #Business
rectangle "KnowledgeBaseImpl.kBaseInternal_addRules(...)" as KBI3 #Business
rectangle "ReteooBuilder.addRule(...)" as RB #Business
rectangle "ReteooRuleBuilder.addRule(...)" as RRB #Business
rectangle "ReteooRuleBuilder.addSubRule(...)" as RRB2 #Business
rectangle "ReteooComponentBuilder.build(...)" as RRB3 #Business

'releationship
KS -down-> KB
KB -down-> KCI
KCI -down-> AKM
AKM -down-> AKM2
AKM2 -down-> AKP
AKP -down-> CKBI
CKBI -down-> CKBI2
CKBI2 -down-> PDB
PDB -down-> PDB2
PDB2 -down-> PDB3
PDB3 -down-> CPD
CPD -down-> CPD2

AKM -down-> AKM3
AKM3 -down-> KBI
KBI -down-> KBI2
KBI2 -down-> KBI3
KBI3 -down-> RB
RB -down-> RRB
RRB -down-> RRB2
RRB2 -down-> RRB3

@enduml
```