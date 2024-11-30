import os
def replace_third_occurrence(folder_path):
    # Check if the folder exists
    if not os.path.isdir(folder_path):
        print("Invalid folder path.")
        return
    # Iterate over all .txt files in the folder
    for filename in os.listdir(folder_path):
        if filename.endswith(".json"):
            file_path = os.path.join(folder_path, filename)
            # Read the file content
            with open(file_path, "r", encoding="utf-8") as file:
                content = file.read()
            # Replace the third occurrence of "goodbye" with "hello"
            occurrences = [i for i in range(len(content)) if content.startswith("\"item\"", i)]
            if len(occurrences) >= 3:
                # Find the index of the third occurrence
                third_index = occurrences[2]
                updated_content = content[:third_index] + "\"id\"" + content[third_index + len("\"item\""):]
                # Write the updated content back to the file
                with open(file_path, "w", encoding="utf-8") as file:
                    file.write(updated_content)
                print(f"Updated file: {filename}")
            else:
                print(f"Less than three occurrences of 'item' found in: {filename}")
# Replace with your folder path
# folder_path = "recipe"
#replace_third_occurrence(folder_path)
import os

def replace_last_word(folder_path):
    # Check if the folder exists
    if not os.path.isdir(folder_path):
        print("Invalid folder path.")
        return

    # Iterate over all .txt files in the folder
    for filename in os.listdir(folder_path):
        if filename.endswith(".json"):
            file_path = os.path.join(folder_path, filename)

            # Read the file content
            with open(file_path, "r", encoding="utf-8") as file:
                content = file.read()

            # Replace the last occurrence of "goodbye" with "hello"
            last_index = content.rfind("\"item\"")
            if last_index != -1:
                updated_content = content[:last_index] + "\"id\"" + content[last_index + len("\"item\""):]

                # Write the updated content back to the file
                with open(file_path, "w", encoding="utf-8") as file:
                    file.write(updated_content)

                print(f"Updated file: {filename}")
            else:
                print(f"No 'goodbye' found in: {filename}")
#
#
# # Replace with your folder path
folder_path = "recipe"
replace_last_word(folder_path)