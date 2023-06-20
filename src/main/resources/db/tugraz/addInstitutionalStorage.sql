INSERT INTO internal_storage (id, VERSION, url, storage_location, backup_location)
VALUES (nextval ('hibernate_sequence'), 0, 'https://cloud.tugraz.at/', 'AUT', 'AUT'),
       (nextval ('hibernate_sequence'), 0, 'https://gitlab.tugraz.at/', 'AUT', 'AUT'),
       (nextval ('hibernate_sequence'), 0, 'https://tu4u.tugraz.at/bedienstete/it-anleitungen-bedienstete/tools-zur-zusammenarbeit/tu-graz-ftp', 'AUT', 'AUT');


INSERT INTO public.inter_storage_translation (id, VERSION, internal_storage_id, language_code, title, description)
VALUES (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://cloud.tugraz.at/' ), 'eng', 'TU Graz Cloud', 'Cloud storage provided by TU Graz'),
       (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://gitlab.tugraz.at/' ), 'eng', 'TU Graz GitLab', 'gitlab instance provided by TU Graz'),
       (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://tu4u.tugraz.at/bedienstete/it-anleitungen-bedienstete/tools-zur-zusammenarbeit/tu-graz-ftp' ), 'eng', 'TU Graz FTP Server', 'FTP server provided by TU Graz');


INSERT INTO inter_storage_translation (id, VERSION, internal_storage_id, language_code, title, description)
VALUES (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://cloud.tugraz.at/' ), 'deu', 'TU Graz Cloud', 'Cloud Speicher der TU Graz'),
       (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://gitlab.tugraz.at/' ), 'deu', 'TU Graz gitlab', 'gitlab Instanz der TU Graz'),
       (nextval ('hibernate_sequence'), 0, (SELECT id FROM internal_storage insto WHERE insto.url = 'https://tu4u.tugraz.at/bedienstete/it-anleitungen-bedienstete/tools-zur-zusammenarbeit/tu-graz-ftp' ), 'deu', 'TU Graz FTP Server', 'FTP Server der TU Graz');
