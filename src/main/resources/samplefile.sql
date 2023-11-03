CREATE TABLE m_scheduled_notifications (
  id BIGINT AUTO_INCREMENT NOT NULL,
   group_name VARCHAR(255) NOT NULL,
   job_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_m_scheduled_notifications PRIMARY KEY (id)
);

DROP TABLE IF EXISTS m_notification_schedules;
CREATE TABLE m_notification_schedules (
  id VARCHAR(255) NOT NULL,
   entity_name VARCHAR(255) NULL,
   quantity VARCHAR(255) NULL,
   start_date datetime NULL,
   end_date datetime NULL,
   no_of_days INT NULL,
   frequency INT NULL,
   frequency_type VARCHAR(255) NULL,
   phone_number VARCHAR(255) NULL,
   CONSTRAINT pk_m_notification_schedules PRIMARY KEY (id)
);
DROP TABLE IF EXISTS m_notification_plans;
CREATE TABLE m_notification_plans (
  id VARCHAR(255) NOT NULL,
   entity_name VARCHAR(255) NULL,
   quantity VARCHAR(255) NULL,
   start_date datetime NULL,
   no_of_days INT NULL,
   frequency INT NULL,
   frequency_type VARCHAR(255) NULL,
   phone_number VARCHAR(255) NULL,
   CONSTRAINT pk_m_notification_plans PRIMARY KEY (id)
);
DROP TABLE IF EXISTS m_notifications;
CREATE TABLE m_notifications (
  schedule_id VARCHAR(255) NOT NULL,
   phone_number VARCHAR(255) NULL,
   start_date datetime NULL,
   end_date datetime NULL,
   entity_name VARCHAR(255) NULL,
   cron VARCHAR(255) NULL,
   CONSTRAINT pk_m_notifications PRIMARY KEY (schedule_id)
);

ALTER TABLE m_notifications ADD CONSTRAINT FK_M_NOTIFICATIONS_ON_SCHEDULE FOREIGN KEY (schedule_id) REFERENCES m_notification_schedules (id);