USE [libManager]
GO
/****** Object:  Table [dbo].[Statistic]    Script Date: 12/02/23 8:40:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Statistic](
	[time] [date] NOT NULL,
	[bank] [float] NULL,
	[numBC] [int] NULL,
	[numReturn] [int] NULL,
	[bookLost] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[time] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-02' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-03' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-05' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-06' AS Date), 0, 2, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-14' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-15' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-16' AS Date), 60000, 0, 0, 1)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-17' AS Date), 130000, 0, 0, 1)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-19' AS Date), 307000, 0, 0, 3)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-20' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-21' AS Date), 580000, 0, 0, 1)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-06-28' AS Date), 0, 0, 1, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-07-02' AS Date), 0, 5, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-07-06' AS Date), 0, 3, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-07-08' AS Date), 0, 2, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-07-10' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-07-11' AS Date), 0, 1, 0, 0)
INSERT [dbo].[Statistic] ([time], [bank], [numBC], [numReturn], [bookLost]) VALUES (CAST(N'2023-11-08' AS Date), 0, 0, 0, 1)
GO
ALTER TABLE [dbo].[Statistic] ADD  DEFAULT ((0)) FOR [bank]
GO
ALTER TABLE [dbo].[Statistic] ADD  DEFAULT ((0)) FOR [numBC]
GO
ALTER TABLE [dbo].[Statistic] ADD  DEFAULT ((0)) FOR [numReturn]
GO
ALTER TABLE [dbo].[Statistic] ADD  DEFAULT ((0)) FOR [bookLost]
GO
