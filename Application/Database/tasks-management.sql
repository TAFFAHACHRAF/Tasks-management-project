-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 24 déc. 2022 à 18:05
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tasks-management`
--

-- --------------------------------------------------------

--
-- Structure de la table `affecter_materiel`
--

CREATE TABLE `affecter_materiel` (
  `MATERIEL_ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `ID` int(11) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `diagramme`
--

CREATE TABLE `diagramme` (
  `ID` int(11) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `PROJET_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `ID` int(11) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DATE` date NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `TASK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_de_travail`
--

CREATE TABLE `order_de_travail` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(50) NOT NULL,
  `TASK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `PROJET_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `CIN` varchar(50) NOT NULL,
  `TEL` varchar(50) NOT NULL,
  `isResponsable` tinyint(1) NOT NULL DEFAULT 0,
  `isIntervenent` tinyint(1) NOT NULL DEFAULT 0,
  `COMPTE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affecter_materiel`
--
ALTER TABLE `affecter_materiel`
  ADD PRIMARY KEY (`MATERIEL_ID`,`TASK_ID`),
  ADD KEY `affecter_materiel_FK_2` (`TASK_ID`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `diagramme`
--
ALTER TABLE `diagramme`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `diagramme_FK_1` (`PROJET_ID`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `materiel_FK_1` (`USER_ID`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TASK_ID_FK_1` (`TASK_ID`);

--
-- Index pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `order_de_travail_FK_1` (`TASK_ID`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `projet_FK_1` (`USER_ID`);

--
-- Index pour la table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `task_FK_1` (`PROJET_ID`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `user_FK_1` (`COMPTE_ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `diagramme`
--
ALTER TABLE `diagramme`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `task`
--
ALTER TABLE `task`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affecter_materiel`
--
ALTER TABLE `affecter_materiel`
  ADD CONSTRAINT `affecter_materiel_FK_1` FOREIGN KEY (`MATERIEL_ID`) REFERENCES `materiel` (`ID`),
  ADD CONSTRAINT `affecter_materiel_FK_2` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `diagramme`
--
ALTER TABLE `diagramme`
  ADD CONSTRAINT `diagramme_FK_1` FOREIGN KEY (`PROJET_ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `materiel_FK_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `TASK_ID_FK_1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  ADD CONSTRAINT `order_de_travail_FK_1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_FK_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_FK_1` FOREIGN KEY (`PROJET_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_FK_1` FOREIGN KEY (`COMPTE_ID`) REFERENCES `compte` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
