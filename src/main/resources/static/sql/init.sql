drop
database if exists wrongquestion;
create
database wrongquestion;
use
wrongquestion;

drop table if exists t_floder;
CREATE TABLE t_folder
(
    folder_id     bigint auto_increment not null comment '����id',
    parent_folder bigint comment '������',
    folder_name   nvarchar(50) NOT NULL comment '��������',
    folder_path   text NOT NULL comment '����·��',
    sub_number    int  NOT NULL comment '�ӽڵ����',
    deleted       boolean default false comment '�Ƿ�ɾ��',
    sub_notes_id  text comment '��Ҷ�ڵ�',
    sub_folder_id text comment '�����ڵ�',
    PRIMARY KEY (folder_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_folder_id on t_folder (folder_id ASC);

insert into t_folder(folder_id, parent_folder, folder_name, folder_path, sub_number, sub_notes_id, sub_folder_id)
values (1, null, '����', '����', 0, '', ''),
       (2, null, '����', '����', 0, '', ''),
       (3, null, '����', '����', 0, '', ''),
       (4, null, '����', '����', 0, '', ''),
       (5, null, '����', '����', 0, '', ''),
       (6, null, '����', '����', 0, '', ''),
       (7, null, '����', '����', 0, '', ''),
       (8, null, '����', '����', 0, '', ''),
       (9, null, '����', '����', 0, '', ''),
       (10, null, '����', '����', 0, '', ''),
       (11, null, '���', '���', 0, '', ''),
       (12, null, '���', '���', 0, '', ''),
       (13, null, '֣��', '֣��', 0, '', ''),
       (14, null, '֣��', '֣��', 0, '', ''),
       (15, null, '��ʮ', '��ʮ', 0, '', ''),
       (16, null, '��ʮ', '��ʮ', 0, '', '');
drop table if exists t_user;
create table t_user
(
    account     varchar(30)   not null comment '�˺�',
    password    varchar(30)   not null comment '����',
    username    varchar(30)   not null comment '�û���',
    status      int default 0 not null comment '���', /* 1��ʾ��ʦ��0��ʾѧ��*/
    telephone   varchar(30)   not null comment '�ֻ�����',
    email       varchar(50)   not null comment '����',
    root        bigint,
    recycle_bin bigint,
    primary key (account),
    foreign key (root) references t_folder (folder_id),
    foreign key (recycle_bin) references t_folder (folder_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_account on t_user (account ASC);

insert into t_user(account, password, username, status, telephone, email, root, recycle_bin)
values ('zhangsan', 'zs123456', '����', 0, '15915712354', 'zhangsan@163.com', 1, 2),
       ('lisi', 'ls123456', '����', 0, '13430241235', 'lisi@qq.com', 3, 4),
       ('wangwu', 'ww123456', '����', 0, '13645236589', 'wangwu@163.com', 5, 6),
       ('chenliu', 'cl123456', '����', 0, '13316397963', 'chenliu@163.com', 7, 8),
       ('xuqi', 'xq123456', '����', 0, '13352679568', 'xuqi@163.com', 9, 10),
       ('maba', 'mb123456', '���', 0, '13654879632', 'maba@163.com', 11, 12),
       ('zhengjiu', 'zj123456', '֣��', 0, '13912546983', 'zhengjiu@163.com', 13, 14),
       ('huangshi', 'hs123456', '��ʮ', 0, '15815632498', 'huangshi@163.com', 15, 6),
       ('linls', 'lls123456', '����ʦ', 1, '15815632498', 'huangshi@163.com', null, null),
       ('zhangls', 'zls123456', '����ʦ', 1, '15815632498', 'huangshi@163.com', null, null),
       ('luols', 'lls123456', '����ʦ', 1, '15815632498', 'huangshi@163.com', null, null);


drop table if exists t_item;
CREATE TABLE t_item
(
    item_id             bigint auto_increment NOT NULL comment '��id',
    item_name           nvarchar(50) NOT NULL comment '������',
    classify            nvarchar(20) NOT NULL comment '���ͷ���',
    item_time           date    NOT NULL comment '��Ŀ����ʱ��',
    deleted       boolean default false comment '�Ƿ�ɾ��',
    item_content        text    NOT NULL comment '��Ŀ����',
    content_photo       blob comment '��ĿͼƬ',
    answer              text    NOT NULL comment '��',
    answer_photo        blob comment '��ͼƬ',
    promulgator_account nvarchar(30) NOT NULL comment '������',
    favorites           int comment '�ղظ���',
    PRIMARY KEY (item_id),
    foreign key (promulgator_account) references t_user (account)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_item_id on t_item (item_id ASC);

drop table if exists t_notes;
CREATE TABLE t_notes
(
    notes_id      bigint auto_increment not null comment '������',
    notes_name    nvarchar(50) not null comment '�������',
    notes_path    text comment '����·��',
    notes_content text comment '��������',
    notes_photo   blob comment '����ͼƬ',
    notes_time    date comment '����ʱ��',
    exercise      bigint comment '��Ӧ����',
    deleted       boolean default false comment '�Ƿ�ɾ��',
    PRIMARY KEY (notes_id),
    foreign key (exercise) references t_item (item_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_notes_id on t_notes (notes_id ASC);


create view v_notes
as
select n.notes_id,
       n.notes_name,
       n.notes_content,
       n.notes_photo,
       n.notes_time,
       i.content_photo,
       i.item_content,
       i.classify,
       i.item_time,
       i.answer,
       i.answer_photo,
       u.username
from t_user u,
     t_item i,
     t_notes n
where n.exercise = i.item_id
  and i.promulgator_account = u.account