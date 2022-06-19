package com.example.DB;

import java.sql.Connection;
import java.sql.*;


public class DBconnection {


    public Boolean is_user_id_unique(String sing_up_user_name) {
        try {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select user_name from users ");
            while (resultSet.next()) {
                if (sing_up_user_name.equals(resultSet.getString("user_name"))) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean sing_up_user_name_and_password(String sing_up_user_name, String sing_up_password, String sing_up_email, String sing_up_phone_number
            , String sign_up_first_name, String sign_up_last_name, String sign_up_q_ans) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users (user_name,pass,email,phone,first_name,last_name,ans) values " +
                    "('" + sing_up_user_name + "','" + sing_up_password + "' ,'" + sing_up_email + "','" + sing_up_phone_number + "' ,'" + sign_up_first_name + "','" + sign_up_last_name + "','" + sign_up_q_ans + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean is_user_id_exist(String sign_in_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select user_name from users ");
            while (resultSet.next()) {
                if (sign_in_user_name.equals(resultSet.getString("user_name"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean is_user_id_and_password_match(String sign_in_user_name, String sign_in_password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select pass from users where user_name='" + sign_in_user_name + "'");
            while (resultSet.next()) {
                System.out.println("13245ty6uyretfghjytryu5y6uytrerthyj");
                System.out.println(resultSet.getString("pass"));
                System.out.println(sign_in_password);
                if (sign_in_password.equals(resultSet.getString("pass"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean is_user_id_and_q_ans_match(String sign_in_user_name, String sign_in_q_ans) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select ans , user_name from users where user_name='" + sign_in_user_name + "'");
            resultSet.next();
            if (sign_in_q_ans.equals(resultSet.getString("ans"))) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean change_password(String sign_in_user_name, String sign_in_password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set pass = '" + sign_in_password + "' where user_name = '" + sign_in_user_name + "'");
            statement.executeUpdate("update users set last_pass_change_date = '" + java.time.LocalDate.now() + "' where user_name = '" + sign_in_user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public String get_sign_in_user_messages(String sign_in_user_name) {         //fuck this shit
        StringBuilder messages = new StringBuilder();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from messages where reciver_id = '" + sign_in_user_name + "'");
            while (resultSet.next()) {
                messages.append(resultSet.getString("id")).append("\n");
                messages.append(resultSet.getString("is_read")).append("\n");
                messages.append(resultSet.getString("is_sender_deleted")).append("\n");
                messages.append(resultSet.getString("sender_id")).append("\n");
                messages.append(resultSet.getString("body")).append("\n");
                messages.append("----------------------------------------------------------------------------------------------------------------------").append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages.toString();
    }

    public void logger(String body) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into logs (body,date) values ('" + body + "','" + java.time.LocalDateTime.now() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void like_message(String user_name, String message_id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            System.out.println("what the fuck");
            statement.executeUpdate("insert into likes (message_id,user_name) values ('" + message_id + "','" + user_name + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void block_user(String user_name, String block_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into blocks (user_name,block_user_name) values ('" + user_name + "','" + block_user_name + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unblock_user(String user_name, String block_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from blocks where user_name = '" + user_name + "' and block_user_name = '" + block_user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove_sign_in_user_friend(String sign_in_user_name, String friend_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from friendship where id1 = '" + sign_in_user_name + "' and id2 = '" + friend_user_name + "'");
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement1 = connection1.createStatement();
            statement1.executeUpdate("delete from friendship where id1 = '" + friend_user_name + "' and id2 = '" + sign_in_user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send_message(String user_name, String friend_user_name, String body) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into messages (sender_id,reciver_id,body) values ('" + user_name + "','" + friend_user_name + "','" + body + "')");
            System.out.println("what the fuck @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean is_blocked(String user_name, String block_user_name) {           //fuck this shit
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from blocks where user_name = '" + user_name + "' and block_user_name = '" + block_user_name + "'");
            while (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean is_friend(String user_name, String friend_user_name) {     //fuck this shit
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from friendship where id1 = '" + user_name + "' and id2 = '" + friend_user_name + "'");
            while (resultSet.next()) {
                return true;
            }
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement1 = connection1.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select * from friendship where id1 = '" + friend_user_name + "' and id2 = '" + user_name + "'");
            while (resultSet1.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void send_friend_request(String user_name, String friend_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into friend_requests (user_name,friend_user_name) values ('" + user_name + "','" + friend_user_name + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get_friend_requests(String user_name) {           //fuck this
        StringBuilder friend_requests = new StringBuilder();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from friend_requests where friend_user_name = '" + user_name + "'");
            while (resultSet.next()) {
                friend_requests.append(resultSet.getString("user_name")).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return friend_requests.toString();
    }

    public void accept_friend_request(String user_name, String friend_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into friendship (id1,id2) values ('" + user_name + "','" + friend_user_name + "')");
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement1 = connection1.createStatement();
            statement1.executeUpdate("delete from friend_requests where user_name = '" + friend_user_name + "' and friend_user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decline_friend_request(String user_name, String friend_user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from friend_requests where user_name = '" + friend_user_name + "' and friend_user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String get_friends(String user_name) {                 // fuck this shit
        StringBuilder friends = new StringBuilder();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from friendship where id1 = '" + user_name + "'");
            while (resultSet.next()) {
                friends.append(resultSet.getString("id2")).append("\n");
            }
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement1 = connection1.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select * from friendship where id2 = '" + user_name + "'");
            while (resultSet1.next()) {
                friends.append(resultSet1.getString("id1")).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends.toString();
    }

    public void delete_account(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Connection connection7 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");

            Statement statement = connection.createStatement();
            Statement statement1 = connection1.createStatement();
            Statement statement2 = connection2.createStatement();
            Statement statement3 = connection3.createStatement();
            Statement statement4 = connection4.createStatement();
            Statement statement5 = connection5.createStatement();
            Statement statement6 = connection6.createStatement();
            Statement statement7 = connection7.createStatement();
            statement.executeUpdate("delete from users where user_name = '" + user_name + "'");
            statement1.executeUpdate("update messages set is_sender_deleted = 'deleted' where sender_id = '" + user_name + "'");
            statement2.executeUpdate("delete from likes where user_name = '" + user_name + "'");
            statement3.executeUpdate("delete from blocks where user_name = '" + user_name + "'");
            statement3.executeUpdate("delete from blocks where block_user_name = '" + user_name + "'");
            statement4.executeUpdate("delete from friendship where id1 = '" + user_name + "'");
            statement5.executeUpdate("delete from friendship where id2 = '" + user_name + "'");
            statement6.executeUpdate("delete from friend_requests where user_name = '" + user_name + "'");
            statement7.executeUpdate("delete from friend_requests where friend_user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void unlock(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set is_locked = 'unlocked' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean is_locked(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            return resultSet.getString("is_locked").equals("locked");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void lock_until(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            int date = java.time.LocalDate.now().getDayOfYear() + 1;
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set is_locked = 'locked',lock_until = '" + date + "' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increase_attempts(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
            resultSet.next();
            int attempts = resultSet.getInt("attemp");
            attempts++;
            statement.executeUpdate("update users set attemp = '" + attempts + "' where user_name = '" + user_name + "'");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increase_attempQ(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            int attempts = resultSet.getInt("attempQ");
            attempts++;
            statement.executeUpdate("update users set attempQ = '" + attempts + "' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean is_attemp_more_than3(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            return resultSet.getInt("attemp") > 3;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean is_attemQ_more_than5(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            return resultSet.getInt("attempQ") > 5;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void reset_attemp(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set attemp = '0' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset_attempQ(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set attempQ = '0' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean is_active(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            return resultSet.getInt("is_active") == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void set_active(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set is_active = '1' where user_name = '" + user_name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int get_lock_until(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user_name + "'");
            resultSet.next();
            return resultSet.getInt("lock_until");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String read_message(int message_id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update messages set is_read = 'read' where id = '" + message_id + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String search_user_name(String user_name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "22nicki18");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users" );
            StringBuilder candidate_user_names = new StringBuilder();
            while (resultSet.next()) {
                if (resultSet.getString("user_name").contains(user_name)) {
                    candidate_user_names.append(resultSet.getString("user_name")).append("\n");
                }
            }
            return candidate_user_names.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user_name;
    }


}
