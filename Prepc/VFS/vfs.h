#define MAX_FILES 100
#define MAX_LEN 50
#define VFS_OPEN 0
#define VFS_CLOSED 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int create_vfs(char*);
int load_vfs(char* file_name_with_path);
int save(char * saved_name,char * path_to_file);
int unload_vfs();
int extract(char * file);
struct file_info
{
	char fname[MAX_LEN];
	int offset;
	int filesize;
};
struct vfs_info
{
	char vfs_name[MAX_LEN];
	int num_files;
	int size;
};
struct vfs_header_info
{
	struct vfs_info v;
	struct file_info files[MAX_FILES];
};
struct vfs
{
struct vfs_header_info header;
FILE*vfs_fp;
int vfs_status;
};
struct file_info f;
struct vfs_info vi;
struct vfs_header_info header;
struct vfs v;
