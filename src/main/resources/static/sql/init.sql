drop
database if exists wrongquestion;
create
database wrongquestion;
use
wrongquestion;

drop table if exists t_floder;
CREATE TABLE t_folder
(
    folder_id     bigint auto_increment not null comment '分组id',
    parent_folder bigint comment '父分组',
    folder_name   nvarchar(50) NOT NULL comment '分组名称',
    folder_path   text NOT NULL comment '分组路劲',
    sub_number    int  NOT NULL comment '子节点个数',
    deleted       boolean default false comment '是否删除',
    sub_notes_id  text comment '子叶节点',
    sub_folder_id text comment '子树节点',
    PRIMARY KEY (folder_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_folder_id on t_folder (folder_id ASC);

insert into t_folder(folder_id, parent_folder, folder_name, folder_path, sub_number, sub_notes_id, sub_folder_id)
values (1, null, '张三', '张三', 0, '', ''),
       (2, null, '张三', '张三', 0, '', ''),
       (3, null, '李四', '李四', 0, '', ''),
       (4, null, '李四', '李四', 0, '', ''),
       (5, null, '王五', '王五', 0, '', ''),
       (6, null, '王五', '王五', 0, '', ''),
       (7, null, '陈六', '陈六', 0, '', ''),
       (8, null, '陈六', '陈六', 0, '', ''),
       (9, null, '许七', '许七', 0, '', ''),
       (10, null, '许七', '许七', 0, '', ''),
       (11, null, '马八', '马八', 0, '', ''),
       (12, null, '马八', '马八', 0, '', ''),
       (13, null, '郑九', '郑九', 0, '', ''),
       (14, null, '郑九', '郑九', 0, '', ''),
       (15, null, '黄十', '黄十', 0, '', ''),
       (16, null, '黄十', '黄十', 0, '', '');
drop table if exists t_user;
create table t_user
(
    account     varchar(30)   not null comment '账号',
    password    varchar(30)   not null comment '密码',
    username    varchar(30)   not null comment '用户名',
    status      int default 0 not null comment '身份', /* 1表示老师，0表示学生*/
    telephone   varchar(30)   not null comment '手机号码',
    email       varchar(50)   not null comment '邮箱',
    root        bigint,
    recycle_bin bigint,
    primary key (account),
    foreign key (root) references t_folder (folder_id),
    foreign key (recycle_bin) references t_folder (folder_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_account on t_user (account ASC);

insert into t_user(account, password, username, status, telephone, email, root, recycle_bin)
values ('zhangsan', 'zs123456', '张三', 0, '15915712354', 'zhangsan@163.com', 1, 2),
       ('lisi', 'ls123456', '李四', 0, '13430241235', 'lisi@qq.com', 3, 4),
       ('wangwu', 'ww123456', '王五', 0, '13645236589', 'wangwu@163.com', 5, 6),
       ('chenliu', 'cl123456', '陈六', 0, '13316397963', 'chenliu@163.com', 7, 8),
       ('xuqi', 'xq123456', '许七', 0, '13352679568', 'xuqi@163.com', 9, 10),
       ('maba', 'mb123456', '马八', 0, '13654879632', 'maba@163.com', 11, 12),
       ('zhengjiu', 'zj123456', '郑九', 0, '13912546983', 'zhengjiu@163.com', 13, 14),
       ('huangshi', 'hs123456', '黄十', 0, '15815632498', 'huangshi@163.com', 15, 6),
       ('linls', 'lls123456', '林老师', 1, '15815632498', 'huangshi@163.com', null, null),
       ('zhangls', 'zls123456', '张老师', 1, '15815632498', 'huangshi@163.com', null, null),
       ('luols', 'lls123456', '罗老师', 1, '15815632498', 'huangshi@163.com', null, null);


drop table if exists t_item;
CREATE TABLE t_item
(
    item_id             bigint auto_increment NOT NULL comment '题id',
    item_name           nvarchar(50) NOT NULL comment '题名称',
    classify            nvarchar(20) NOT NULL comment '题型分类',
    item_time           date    NOT NULL comment '题目发布时间',
    deleted       boolean default false comment '是否删除',
    item_content        text    NOT NULL comment '题目内容',
    content_photo       blob comment '题目图片',
    answer              text    NOT NULL comment '答案',
    answer_photo        blob comment '答案图片',
    promulgator_account nvarchar(30) NOT NULL comment '发布者',
    favorites           int comment '收藏个数',
    PRIMARY KEY (item_id),
    foreign key (promulgator_account) references t_user (account)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
create index index_item_id on t_item (item_id ASC);

drop table if exists t_notes;
CREATE TABLE t_notes
(
    notes_id      bigint auto_increment not null comment '错题编号',
    notes_name    nvarchar(50) not null comment '错题标题',
    notes_path    text comment '错题路劲',
    notes_content text comment '错题内容',
    notes_photo   blob comment '错题图片',
    notes_time    date comment '错题时间',
    exercise      bigint comment '对应的题',
    deleted       boolean default false comment '是否删除',
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