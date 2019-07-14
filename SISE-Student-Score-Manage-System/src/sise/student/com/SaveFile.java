package sise.student.com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SaveFile {
	private static String sql;
	private static boolean key;
//�����꼶����
	public static void set() {
		File file=new File("tb_gradeinfo.txt");
		FileWriter fw=null;
		try {
			fw=new FileWriter(file);
			if(file.exists()) {
				fw.write(new String(""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			file.createNewFile();
			fw=new FileWriter(file,true);
			fw.write("�꼶���\t\t�꼶����\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sql="select * from tb_gradeinfo";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {
				String �꼶���=DBHelper.rs.getString("gid");
				String �꼶����=DBHelper.rs.getString("grade");
				try {
					fw.write(�꼶���+"\t\t"+�꼶����+"\n");
					fw.flush();
					key=true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(key==true) {
				JOptionPane.showMessageDialog(null, "���̳ɹ���");
				key=false;
			}
			else {
				JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}}
		}
		
	//����༶����
		public static void setclass() {
			File file=new File("tb_classinfo.txt");
			FileWriter fw=null;
			try {
				fw=new FileWriter(file);
				if(file.exists()) {
					fw.write(new String(""));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				file.createNewFile();
				fw=new FileWriter(file,true);
				fw.write("�༶���\t\t�༶����\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			sql="select * from tb_classinfo";
			DBHelper.select(sql);
			try {
				while(DBHelper.rs.next()) {
					String �༶���=DBHelper.rs.getString("cid");
					String �༶����=DBHelper.rs.getString("sclass");
					try {
						fw.write(�༶���+"\t\t"+�༶����+"\n");
						fw.flush();
						key=true;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(key==true) {
					JOptionPane.showMessageDialog(null, "���̳ɹ���");
					key=false;
				}
				else {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(fw!=null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}}
			}
		//����γ�����
			public static void setcourse() {
				File file=new File("tb_subject.txt");
				FileWriter fw=null;
				try {
					fw=new FileWriter(file);
					if(file.exists()) {
						fw.write(new String(""));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					file.createNewFile();
					fw=new FileWriter(file,true);
					fw.write("��Ŀ���\t\t��Ŀ����\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				sql="select * from tb_subject";
				DBHelper.select(sql);
				try {
					while(DBHelper.rs.next()) {
						String ��Ŀ���=DBHelper.rs.getString("cid");
						String ��Ŀ����=DBHelper.rs.getString("course");
						try {
							fw.write(��Ŀ���+"\t\t"+��Ŀ����+"\n");
							fw.flush();
							key=true;
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(key==true) {
						JOptionPane.showMessageDialog(null, "���̳ɹ���");
						key=false;
					}
					else {
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(fw!=null) {
						try {
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}}
				}
			
			
			//���濼������
				public static void setExamkinds() {
					File file=new File("tb_examkinds.txt");
					FileWriter fw=null;
					try {
						fw=new FileWriter(file);
						if(file.exists()) {
							fw.write(new String(""));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						file.createNewFile();
						fw=new FileWriter(file,true);
						fw.write("��Ŀ\t\t��������\n");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					sql="select * from tb_examkinds";
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {
							String ��Ŀ=DBHelper.rs.getString("exam");
							String ��Ŀ����=DBHelper.rs.getString("checka");
							try {
								fw.write(��Ŀ+"\t\t"+��Ŀ����+"\n");
								fw.flush();
								key=true;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if(key==true) {
							JOptionPane.showMessageDialog(null, "���̳ɹ���");
							key=false;
						}
						else {
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						if(fw!=null) {
							try {
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}}
					}
		//�����ʦ��Ϣ
					public static void setTeacher() {
						File file=new File("tb_teacher.txt");
						FileWriter fw=null;
						try {
							fw=new FileWriter(file);
							if(file.exists()) {
								fw.write(new String(""));
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							file.createNewFile();
							fw=new FileWriter(file,true);
							fw.write("��ʦ���\t\t�����꼶\t\t���̰༶\t\t��ʦ����\t\t�Ա�\t\t���̿γ�\t\t��ϵ�绰\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						sql="select * from tb_teacher";
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {
								String ��ʦ���=DBHelper.rs.getString("tid");
								String �����꼶=DBHelper.rs.getString("tgrade");
								String ���̰༶=DBHelper.rs.getString("tclass");
								String ��ʦ����=DBHelper.rs.getString("tname");
								String �Ա�=DBHelper.rs.getString("gender");
								String ���̿γ�=DBHelper.rs.getString("course");
								String ��ϵ�绰=DBHelper.rs.getString("phone");
								try {
									fw.write(��ʦ���+"\t\t"+�����꼶+"\t\t"+���̰༶+"\t\t"+��ʦ����+"\t\t"+�Ա�+"\t\t"+���̿γ�+"\t\t"+��ϵ�绰+"\n");
									fw.flush();
									key=true;
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if(key==true) {
								JOptionPane.showMessageDialog(null, "���̳ɹ���");
								key=false;
							}
							else {
								JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						finally {
							if(fw!=null) {
								try {
									fw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
						
						//����ѧ������
						public static void setstudent() {
							File file=new File("tb_studentinfo.txt");
							FileWriter fw=null;
							try {
								fw=new FileWriter(file);
								if(file.exists()) {
									fw.write(new String(""));
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								file.createNewFile();
								fw=new FileWriter(file,true);
								fw.write("ѧ�����\t\t�꼶\t\t�༶����\t\tѧ������\t\t�Ա�\t\t����\t\t��ͥ��ַ\t\t��ϵ�绰\n");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							sql="select * from tb_studentinfo";
							DBHelper.select(sql);
							try {
								while(DBHelper.rs.next()) {
									String ѧ�����=DBHelper.rs.getString("sid");
									String �꼶=DBHelper.rs.getString("grade");
									String �༶����=DBHelper.rs.getString("sclass");
									String ѧ������=DBHelper.rs.getString("sname");
									String �Ա�=DBHelper.rs.getString("gender");
									String ����=DBHelper.rs.getString("age");
									String ��ͥ��ַ=DBHelper.rs.getString("address");
									String ��ϵ�绰=DBHelper.rs.getString("phone");
									try {
										fw.write(ѧ�����+"\t\t"+�꼶+"\t\t"+�༶����+"\t\t"+ѧ������+"\t\t"+�Ա�+"\t\t"+����+"\t\t"+��ͥ��ַ+"\t\t"+��ϵ�绰+"\n");
										fw.flush();
										key=true;
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								if(key==true) {
									JOptionPane.showMessageDialog(null, "���̳ɹ���");
									key=false;
								}
								else {
									JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							finally {
								if(fw!=null) {
									try {
										fw.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
