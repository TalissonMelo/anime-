alter table escola add uuid varchar(36) not null after id;
update escola set uuid = uuid();
alter table escola add constraint un_escola_codigo unique (uuid);

alter table professor add uuid varchar(36) not null after id;
update professor set uuid = uuid();
alter table professor add constraint uk_professor_codigo unique (uuid);