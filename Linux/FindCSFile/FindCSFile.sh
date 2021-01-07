#bin/bash

# Requirements
# Specific Directory : CodeSquad
# Child Directory : day1 ~ day16
# Find File : .cs extend File
# If find .cs extend files, compress to .zip file

# Definition Field

SPECIFIC_DIRECTORY=/Users/jeongseunghyeon/Desktop/공부폴더/TIL/Linux/CodeSquad

cd ${SPECIFIC_DIRECTORY} # Move To directory

CHILD_DIRECTORY=`ls -all | grep day | awk '{print $9}'`
TODAY=`date +%Y-%m-%d`
BACKUP_FOLDER_NAME=backup
REMOTE_RECEIVE_FOLDER_NAME=backup
PORT=5000
IP=172.30.1.47
USERNAME=roach
CHANGE_MOD=767

# Definition Function

inspectionExistFile() {
        local CS_FILE=`ls -all | grep .cs | awk '{print $9}'`
        if [ -z ${CS_FILE} ] ; then
                echo "${folder} have not .cs file"
        fi
}

# Make backup Folder
mkdir -p ${BACKUP_FOLDER_NAME}/${TODAY}

#Save child Directory to Array
for folder in ${CHILD_DIRECTORY}
do
	cd /${SPECIFIC_DIRECTORY}/${folder}/
	EXTEND_CS_FILE=`ls -all | grep .cs | awk '{print $9}'`	
	
	# If Exist .CS File?
	inspectionExistFile # func

	for csfile in ${EXTEND_CS_FILE}
	do
		if [ -e ${csfile} ] ; then
			cp -r ${csfile} ../${BACKUP_FOLDER_NAME}/${TODAY}
		fi
	done
done

#Move Directory to Backup Folder
cd ..
cd ${BACKUP_FOLDER_NAME}/${TODAY}

#Compress File
zip $TODAY.zip ./*

chmod ${CHANGE_MOD} $TODAY.zip

scp -P ${PORT} $TODAY.zip ${USERNAME}@${IP}:~/${REMOTE_RECEIVE_FOLDER_NAME}/
