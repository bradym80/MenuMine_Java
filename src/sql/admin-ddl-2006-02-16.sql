/*This script is no longer necessary */

alter table fieldstodisplaybean add column MasterfoodId tinyint not null default 0;
alter table fieldstodisplaybean add column ProteinFishShrimpSeafood tinyint not null default 0;

alter table inValues rename to invalues;
alter table andValues rename to andvalues;
alter table orValues rename to orvalues;
alter table rollUpElement rename to rollupelement;
alter table savedQuery rename to savedquery;