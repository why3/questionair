
--
-- Dumping data for table `t_answer`
--

LOCK TABLES `t_answer` WRITE;
/*!40000 ALTER TABLE `t_answer` DISABLE KEYS */;
INSERT INTO `t_answer` VALUES (7,'q1','m','善于分析'),(7,'q10','p','友善'),(7,'q11','s','可爱'),(7,'q12','m','文化修养'),(7,'q13','c','独立'),(7,'q14','p','尖刻幽默'),(7,'q15','s','喜交朋友'),(7,'q16','p','容忍'),(7,'q17','p','聆听者'),(7,'q18','s','惹人喜爱'),(7,'q19','m','完美主义者'),(7,'q2','s','喜好娱乐'),(7,'q20','c','无畏'),(7,'q21','m','忸怩'),(7,'q22','p','缺乏热情'),(7,'q23','c','逆反'),(7,'q24','p','胆小'),(7,'q25','s','好插嘴'),(7,'q26','s','难预测'),(7,'q27','m','难于取悦'),(7,'q28','m','悲观'),(7,'q29','m','孤芳自赏'),(7,'q3','s','善于社交'),(7,'q30','s','天真'),(7,'q31','m','不善交际'),(7,'q32','c','不圆滑老练'),(7,'q33','c','跋扈'),(7,'q34','s','缺乏毅力'),(7,'q35','p','喃喃自语'),(7,'q36','p','缓慢'),(7,'q37','m','孤僻'),(7,'q38','s','不专注'),(7,'q39','c','轻率'),(7,'q4','s','使人认同'),(7,'q40','p','妥协'),(7,'q5','s','使人振作'),(7,'q6','p','满足'),(7,'q7','p','耐性'),(7,'q8','m','时间性'),(7,'q9','s','乐观'),(8,'q1','c','富于冒险'),(8,'q10','c','强迫性'),(8,'q11','c','勇敢'),(8,'q12','p','贯彻始终'),(8,'q13','s','富激情性'),(8,'q14','p','尖刻幽默'),(8,'q15','m','音乐性'),(8,'q16','s','多言'),(8,'q17','m','忠心'),(8,'q18','c','首领'),(8,'q19','p','和气'),(8,'q2','m','坚持不懈'),(8,'q20','c','无畏'),(8,'q21','p','乏味'),(8,'q22','s','散漫'),(8,'q23','m','怨恨'),(8,'q24','s','健忘'),(8,'q25','p','优柔寡断'),(8,'q26','s','难预测'),(8,'q27','c','固执'),(8,'q28','m','悲观'),(8,'q29','m','孤芳自赏'),(8,'q3','s','善于社交'),(8,'q30','m','消极'),(8,'q31','c','工作狂'),(8,'q32','c','不圆滑老练'),(8,'q33','s','生活紊乱'),(8,'q34','p','无异议'),(8,'q35','p','喃喃自语'),(8,'q36','c','顽固'),(8,'q37','p','懒惰'),(8,'q38','p','拖延'),(8,'q39','p','勉强'),(8,'q4','p','自控性'),(8,'q40','m','好批评'),(8,'q5','c','善于应变'),(8,'q6','s','生机勃勃'),(8,'q7','c','积极'),(8,'q8','s','无拘无束'),(8,'q9','s','乐观'),(9,'q1','p','适应能力强'),(9,'q10','s','有趣'),(9,'q11','c','勇敢'),(9,'q12','s','令人高兴'),(9,'q13','c','独立'),(9,'q14','m','深沉'),(9,'q15','s','喜交朋友'),(9,'q16','m','考虑周到'),(9,'q17','m','忠心'),(9,'q18','m','制图者'),(9,'q19','c','勤劳'),(9,'q2','p','平和'),(9,'q20','s','跳跃型'),(9,'q21','s','露骨'),(9,'q22','s','散漫'),(9,'q23','p','保留'),(9,'q24','p','胆小'),(9,'q25','p','优柔寡断'),(9,'q26','m','不受欢迎'),(9,'q27','p','犹豫不决'),(9,'q28','s','放任'),(9,'q29','s','易怒'),(9,'q3','s','善于社交'),(9,'q30','p','冷漠'),(9,'q31','s','喜获认同'),(9,'q32','m','过分敏感'),(9,'q33','p','腼腆'),(9,'q34','p','无异议'),(9,'q35','c','喜操纵'),(9,'q36','p','缓慢'),(9,'q37','c','统治欲'),(9,'q38','p','拖延'),(9,'q39','c','轻率'),(9,'q4','c','竞争性'),(9,'q40','m','好批评'),(9,'q5','s','使人振作'),(9,'q6','c','自立'),(9,'q7','m','计划者'),(9,'q8','c','肯定'),(9,'q9','m','井井有条');
/*!40000 ALTER TABLE `t_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_answer_set`
--

LOCK TABLES `t_answer_set` WRITE;
/*!40000 ALTER TABLE `t_answer_set` DISABLE KEYS */;
INSERT INTO `t_answer_set` VALUES (7,'2013-07-14 23:06:42',1,4,'s'),(8,'2013-07-15 15:04:47',1,4,'c'),(9,'2013-07-15 15:06:43',1,4,'s');
/*!40000 ALTER TABLE `t_answer_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_question_set`
--

LOCK TABLES `t_question_set` WRITE;
/*!40000 ALTER TABLE `t_question_set` DISABLE KEYS */;
INSERT INTO `t_question_set` VALUES (1, '性格测试', '{\"q1\":{\"c\":\"富于冒险\",\"m\":\"善于分析\",\"p\":\"适应能力强\",\"s\":\"生动\"},\"q10\":{\"c\":\"强迫性\",\"m\":\"忠诚\",\"p\":\"友善\",\"s\":\"有趣\"},\"q11\":{\"c\":\"勇敢\",\"m\":\"注意细节\",\"p\":\"外交手腕\",\"s\":\"可爱\"},\"q12\":{\"c\":\"自信\",\"m\":\"文化修养\",\"p\":\"贯彻始终\",\"s\":\"令人高兴\"},\"q13\":{\"c\":\"独立\",\"m\":\"理想主义\",\"p\":\"无攻击性\",\"s\":\"富激情性\"},\"q14\":{\"c\":\"果断\",\"m\":\"深沉\",\"p\":\"尖刻幽默\",\"s\":\"感情外露\"},\"q15\":{\"c\":\"发起者\",\"m\":\"音乐性\",\"p\":\"调解者\",\"s\":\"喜交朋友\"},\"q16\":{\"c\":\"执着\",\"m\":\"考虑周到\",\"p\":\"容忍\",\"s\":\"多言\"},\"q17\":{\"c\":\"领导者\",\"m\":\"忠心\",\"p\":\"聆听者\",\"s\":\"活力充沛\"},\"q18\":{\"c\":\"首领\",\"m\":\"制图者\",\"p\":\"知足\",\"s\":\"惹人喜爱\"},\"q19\":{\"c\":\"勤劳\",\"m\":\"完美主义者\",\"p\":\"和气\",\"s\":\"受欢迎\"},\"q2\":{\"c\":\"善于说服\",\"m\":\"坚持不懈\",\"p\":\"平和\",\"s\":\"喜好娱乐\"},\"q20\":{\"c\":\"无畏\",\"m\":\"规范型\",\"p\":\"平衡\",\"s\":\"跳跃型\"},\"q21\":{\"c\":\"专横\",\"m\":\"忸怩\",\"p\":\"乏味\",\"s\":\"露骨\"},\"q22\":{\"c\":\"无同情心\",\"m\":\"不宽恕\",\"p\":\"缺乏热情\",\"s\":\"散漫\"},\"q23\":{\"c\":\"逆反\",\"m\":\"怨恨\",\"p\":\"保留\",\"s\":\"唠叨\"},\"q24\":{\"c\":\"率直\",\"m\":\"挑剔\",\"p\":\"胆小\",\"s\":\"健忘\"},\"q25\":{\"c\":\"没耐性\",\"m\":\"无安全感\",\"p\":\"优柔寡断\",\"s\":\"好插嘴\"},\"q26\":{\"c\":\"缺同情心\",\"m\":\"不受欢迎\",\"p\":\"不参与\",\"s\":\"难预测\"},\"q27\":{\"c\":\"固执\",\"m\":\"难于取悦\",\"p\":\"犹豫不决\",\"s\":\"即兴\"},\"q28\":{\"c\":\"自负\",\"m\":\"悲观\",\"p\":\"平淡\",\"s\":\"放任\"},\"q29\":{\"c\":\"好争吵\",\"m\":\"孤芳自赏\",\"p\":\"无目标\",\"s\":\"易怒\"},\"q3\":{\"c\":\"意志坚定\",\"m\":\"自我牺牲\",\"p\":\"顺服\",\"s\":\"善于社交\"},\"q30\":{\"c\":\"鲁莽\",\"m\":\"消极\",\"p\":\"冷漠\",\"s\":\"天真\"},\"q31\":{\"c\":\"工作狂\",\"m\":\"不善交际\",\"p\":\"担忧\",\"s\":\"喜获认同\"},\"q32\":{\"c\":\"不圆滑老练\",\"m\":\"过分敏感\",\"p\":\"胆怯\",\"s\":\"喋喋不休\"},\"q33\":{\"c\":\"跋扈\",\"m\":\"抑郁\",\"p\":\"腼腆\",\"s\":\"生活紊乱\"},\"q34\":{\"c\":\"不容忍\",\"m\":\"内向\",\"p\":\"无异议\",\"s\":\"缺乏毅力\"},\"q35\":{\"c\":\"喜操纵\",\"m\":\"情绪化\",\"p\":\"喃喃自语\",\"s\":\"杂乱无章\"},\"q36\":{\"c\":\"顽固\",\"m\":\"有戒心\",\"p\":\"缓慢\",\"s\":\"好表现\"},\"q37\":{\"c\":\"统治欲\",\"m\":\"孤僻\",\"p\":\"懒惰\",\"s\":\"大嗓门\"},\"q38\":{\"c\":\"易怒\",\"m\":\"多疑\",\"p\":\"拖延\",\"s\":\"不专注\"},\"q39\":{\"c\":\"轻率\",\"m\":\"报复型\",\"p\":\"勉强\",\"s\":\"烦躁\"},\"q4\":{\"c\":\"竞争性\",\"m\":\"体贴\",\"p\":\"自控性\",\"s\":\"使人认同\"},\"q40\":{\"c\":\"狡猾\",\"m\":\"好批评\",\"p\":\"妥协\",\"s\":\"善变\"},\"q5\":{\"c\":\"善于应变\",\"m\":\"受尊重\",\"p\":\"含蓄\",\"s\":\"使人振作\"},\"q6\":{\"c\":\"自立\",\"m\":\"敏感\",\"p\":\"满足\",\"s\":\"生机勃勃\"},\"q7\":{\"c\":\"积极\",\"m\":\"计划者\",\"p\":\"耐性\",\"s\":\"推动者\"},\"q8\":{\"c\":\"肯定\",\"m\":\"时间性\",\"p\":\"羞涩\",\"s\":\"无拘无束\"},\"q9\":{\"c\":\"坦率\",\"m\":\"井井有条\",\"p\":\"迁就\",\"s\":\"乐观\"}}');
/*!40000 ALTER TABLE `t_question_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (2,'why3','123456',1),(3,'you','123',0),(4,'asdf','asdf',0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
