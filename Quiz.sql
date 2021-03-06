USE [master]
GO
/****** Object:  Database [Quiz]    Script Date: 18/04/2017 4:46:32 CH ******/
CREATE DATABASE [Quiz]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Quiz', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Quiz.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Quiz_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Quiz_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Quiz] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Quiz].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Quiz] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Quiz] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Quiz] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Quiz] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Quiz] SET ARITHABORT OFF 
GO
ALTER DATABASE [Quiz] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Quiz] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Quiz] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Quiz] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Quiz] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Quiz] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Quiz] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Quiz] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Quiz] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Quiz] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Quiz] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Quiz] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Quiz] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Quiz] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Quiz] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Quiz] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Quiz] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Quiz] SET RECOVERY FULL 
GO
ALTER DATABASE [Quiz] SET  MULTI_USER 
GO
ALTER DATABASE [Quiz] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Quiz] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Quiz] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Quiz] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Quiz] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Quiz', N'ON'
GO
USE [Quiz]
GO
/****** Object:  Table [dbo].[account]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account](
	[id_acc] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[birth] [date] NULL,
	[job] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[email] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[state] [bit] NULL CONSTRAINT [DF_account_state]  DEFAULT ((0)),
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[id_acc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[clList2]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[clList2](
	[pmcode] [nvarchar](10) NOT NULL,
	[cdgr] [nvarchar](10) NOT NULL,
	[val_name] [nvarchar](50) NOT NULL,
	[param_name] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_clList2] PRIMARY KEY CLUSTERED 
(
	[param_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[comment]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id_post] [int] NOT NULL,
	[id_acc] [int] NOT NULL,
	[comment_content] [nvarchar](100) NOT NULL,
	[comment_time] [datetime] NOT NULL,
	[comment_state] [bit] NOT NULL,
	[id_comment] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_comment] PRIMARY KEY CLUSTERED 
(
	[id_comment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[correct_answer]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[correct_answer](
	[id_question] [int] NOT NULL,
	[id_answer] [int] NOT NULL,
	[answer_content] [text] NULL,
	[correct_answer] [bit] NULL,
 CONSTRAINT [PK_correct_answer] PRIMARY KEY CLUSTERED 
(
	[id_question] ASC,
	[id_answer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[post]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post](
	[id_post] [int] IDENTITY(1,1) NOT NULL,
	[post_content] [nvarchar](100) NOT NULL,
	[post_date] [date] NOT NULL,
	[id_connect] [int] NOT NULL,
	[id_post_type] [int] NOT NULL,
	[id_acc] [int] NOT NULL,
 CONSTRAINT [PK_post] PRIMARY KEY CLUSTERED 
(
	[id_post] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[post_manage]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post_manage](
	[id_post] [int] NOT NULL,
	[id_room] [int] NOT NULL,
 CONSTRAINT [PK_post_manage_1] PRIMARY KEY CLUSTERED 
(
	[id_post] ASC,
	[id_room] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[question]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question](
	[id_question] [int] IDENTITY(1,1) NOT NULL,
	[question_content] [text] NULL,
	[question_type] [int] NULL,
 CONSTRAINT [PK_question] PRIMARY KEY CLUSTERED 
(
	[id_question] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[room]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[id_room] [int] IDENTITY(1,1) NOT NULL,
	[room_name] [nvarchar](50) NOT NULL,
	[room_descr] [nvarchar](100) NOT NULL,
	[id_acc] [int] NOT NULL,
 CONSTRAINT [PK_room] PRIMARY KEY CLUSTERED 
(
	[id_room] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[room_manage]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room_manage](
	[id_room] [int] NOT NULL,
	[id_acc] [int] NOT NULL,
 CONSTRAINT [PK_room_manage] PRIMARY KEY CLUSTERED 
(
	[id_room] ASC,
	[id_acc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[task]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[task](
	[id_test] [int] NOT NULL,
	[id_acc] [int] NOT NULL,
	[id_question] [int] NOT NULL,
	[id_answer] [int] NULL,
	[note] [text] NULL,
 CONSTRAINT [PK_task] PRIMARY KEY CLUSTERED 
(
	[id_test] ASC,
	[id_acc] ASC,
	[id_question] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[test]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test](
	[id_test] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NULL,
	[date_start] [date] NULL,
	[date_end] [date] NULL,
 CONSTRAINT [PK_test] PRIMARY KEY CLUSTERED 
(
	[id_test] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[test_content]    Script Date: 18/04/2017 4:46:32 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_content](
	[id_test] [int] NOT NULL,
	[id_question] [int] NOT NULL,
 CONSTRAINT [PK_test_content] PRIMARY KEY CLUSTERED 
(
	[id_test] ASC,
	[id_question] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([id_acc], [name], [birth], [job], [gender], [email], [password], [state]) VALUES (1, N'Trương Tam Lang', CAST(N'1996-02-16' AS Date), N'Sinh Viên', 0, N'ttlang162@gmail.com', N'1234', 1)
SET IDENTITY_INSERT [dbo].[account] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_account]    Script Date: 18/04/2017 4:46:32 CH ******/
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [IX_account] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_account] FOREIGN KEY([id_acc])
REFERENCES [dbo].[account] ([id_acc])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_account]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_post] FOREIGN KEY([id_post])
REFERENCES [dbo].[post] ([id_post])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_post]
GO
ALTER TABLE [dbo].[correct_answer]  WITH CHECK ADD  CONSTRAINT [FK_correct_answer_question] FOREIGN KEY([id_question])
REFERENCES [dbo].[question] ([id_question])
GO
ALTER TABLE [dbo].[correct_answer] CHECK CONSTRAINT [FK_correct_answer_question]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK_post_account] FOREIGN KEY([id_acc])
REFERENCES [dbo].[account] ([id_acc])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK_post_account]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK_post_clList2] FOREIGN KEY([id_post_type])
REFERENCES [dbo].[clList2] ([param_name])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK_post_clList2]
GO
ALTER TABLE [dbo].[post_manage]  WITH CHECK ADD  CONSTRAINT [FK_post_manage_post] FOREIGN KEY([id_post])
REFERENCES [dbo].[post] ([id_post])
GO
ALTER TABLE [dbo].[post_manage] CHECK CONSTRAINT [FK_post_manage_post]
GO
ALTER TABLE [dbo].[post_manage]  WITH CHECK ADD  CONSTRAINT [FK_post_manage_room] FOREIGN KEY([id_room])
REFERENCES [dbo].[room] ([id_room])
GO
ALTER TABLE [dbo].[post_manage] CHECK CONSTRAINT [FK_post_manage_room]
GO
ALTER TABLE [dbo].[question]  WITH CHECK ADD  CONSTRAINT [FK_question_clList22] FOREIGN KEY([question_type])
REFERENCES [dbo].[clList2] ([param_name])
GO
ALTER TABLE [dbo].[question] CHECK CONSTRAINT [FK_question_clList22]
GO
ALTER TABLE [dbo].[room]  WITH CHECK ADD  CONSTRAINT [FK_room_account] FOREIGN KEY([id_acc])
REFERENCES [dbo].[account] ([id_acc])
GO
ALTER TABLE [dbo].[room] CHECK CONSTRAINT [FK_room_account]
GO
ALTER TABLE [dbo].[room_manage]  WITH CHECK ADD  CONSTRAINT [FK_room_manage_account] FOREIGN KEY([id_acc])
REFERENCES [dbo].[account] ([id_acc])
GO
ALTER TABLE [dbo].[room_manage] CHECK CONSTRAINT [FK_room_manage_account]
GO
ALTER TABLE [dbo].[room_manage]  WITH CHECK ADD  CONSTRAINT [FK_room_manage_room] FOREIGN KEY([id_room])
REFERENCES [dbo].[room] ([id_room])
GO
ALTER TABLE [dbo].[room_manage] CHECK CONSTRAINT [FK_room_manage_room]
GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK_task_account] FOREIGN KEY([id_acc])
REFERENCES [dbo].[account] ([id_acc])
GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK_task_account]
GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK_task_question] FOREIGN KEY([id_question])
REFERENCES [dbo].[question] ([id_question])
GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK_task_question]
GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK_task_test] FOREIGN KEY([id_test])
REFERENCES [dbo].[test] ([id_test])
GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK_task_test]
GO
ALTER TABLE [dbo].[test_content]  WITH CHECK ADD  CONSTRAINT [FK_test_content_question] FOREIGN KEY([id_question])
REFERENCES [dbo].[question] ([id_question])
GO
ALTER TABLE [dbo].[test_content] CHECK CONSTRAINT [FK_test_content_question]
GO
ALTER TABLE [dbo].[test_content]  WITH CHECK ADD  CONSTRAINT [FK_test_content_test] FOREIGN KEY([id_test])
REFERENCES [dbo].[test] ([id_test])
GO
ALTER TABLE [dbo].[test_content] CHECK CONSTRAINT [FK_test_content_test]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'mã phòng học' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'room', @level2type=N'COLUMN',@level2name=N'id_room'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'tên phòng học' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'room', @level2type=N'COLUMN',@level2name=N'room_name'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'mô tả' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'room', @level2type=N'COLUMN',@level2name=N'room_descr'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'quản lý phòng học' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'room_manage'
GO
USE [master]
GO
ALTER DATABASE [Quiz] SET  READ_WRITE 
GO
